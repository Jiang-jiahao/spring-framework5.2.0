package com.jjh.anno.circularReferences.learn;

import com.jjh.anno.circularReferences.A;
import com.jjh.anno.circularReferences.B;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 一级缓存+二级缓存+三级缓存+锁解决循环依赖问题，使其aop只执行一次
 *
 */
public class FourSolveCircularReferencesTest {

	//bean定义缓存
	private static final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

	//用来存储正在创建的bean
	private static final Set<String> singletonsCurrentlyInCreation = Collections.newSetFromMap(new ConcurrentHashMap<>(16));

	//一级缓存
	private static final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

	//二级缓存
	private static final Map<String, Object> earlySingletonObjects = new HashMap<>(16);

	//三级缓存
	private static final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);


	public static void main(String[] args) throws Exception {
		newApplicationContext();
		IA a = (IA) getBean("a");
		a.hello();
	}

	//创建容器
	private static void newApplicationContext() throws Exception {
		//加载Bean定义
		loadBeanDefinitions();
		//循环Bean定义创建Bean
		for (String beanName : beanDefinitionMap.keySet()) {
			getBean(beanName);
		}
	}


	//创建Bean
	private static Object getBean(String beanName) throws Exception {
		/**
         * 先从一级缓存读取
		 */
		if (singletonObjects.get(beanName) != null) {
			return singletonObjects.get(beanName);
		}

		/**
         * 加锁
		 */
		synchronized (singletonObjects) {


			/**
			 * 再次判断是否获取到了，有则返回
			 */
			if (singletonObjects.get(beanName) != null) {
				return singletonObjects.get(beanName);
			}

			/**
			 * 只针对循环依赖的类进行aop操作
			 * 如果正在创建中，则是循环依赖
			 */
			if(singletonsCurrentlyInCreation.contains(beanName)){
				//从二级缓存读取，获取到的是不完整的bean（这里其实只有循环依赖的bean才会用到二级缓存）
				Object o = earlySingletonObjects.get(beanName);
				if(o == null){
					//三级缓存拿
					ObjectFactory<?> objectFactory = singletonFactories.get(beanName);
					System.out.println(beanName + " begin aop...");
					o = objectFactory.getObject();
					earlySingletonObjects.put(beanName,o);
				}
			}

			/**
             * 从二级缓存读取，获取到的是不完整的bean
			 */
			if (earlySingletonObjects.get(beanName) != null) {
				return earlySingletonObjects.get(beanName);
			}

			singletonsCurrentlyInCreation.add(beanName);

			//2、实例化
			RootBeanDefinition beanDefinition = (RootBeanDefinition) beanDefinitionMap.get(beanName);
			Class<?> beanClass = beanDefinition.getBeanClass();
			Object bean = beanClass.newInstance();

			/**
			 * 实例化后将有需要的（循环依赖的类）加入三级缓存
			 */
			Object finalBean = bean;
			singletonFactories.put(beanName,() -> new JdkProxyBeanPostProcessor().getEarlyBeanReference(finalBean, beanName));



			//3、属性注入
			Field[] declaredFields = beanClass.getDeclaredFields();
			for (Field declaredField : declaredFields) {
				//循环每一个属性，判断是否有@Autowried注解
				Autowired annotation = declaredField.getAnnotation(Autowired.class);
				if (annotation != null) {
					//获取到属性的名称
					String name = declaredField.getName();
					Object properBean = getBean(name);
					declaredField.setAccessible(true);
					//给bean设置进创建好的属性对象
					declaredField.set(bean, properBean);
				}
			}
			//4、初始化 生命周期回调 initMethod Aware 非循环依赖的类Aop创建动态代理...
			bean = new JdkProxyBeanPostProcessor().getEarlyBeanReference(bean, beanName);

			System.out.println("init " + beanName + " ...");
			//5、加入一级缓存
			singletonObjects.put(beanName, bean);
			/**
             * 删除二级缓存数据
			 */
			earlySingletonObjects.remove(beanName);
			return bean;
		}
	}


	//加载Bean定义
	private static void loadBeanDefinitions() {
		RootBeanDefinition aBeanDefinition = new RootBeanDefinition(A.class);
		RootBeanDefinition bBeanDefinition = new RootBeanDefinition(B.class);
		RootBeanDefinition cBeanDefinition = new RootBeanDefinition(C.class);
		beanDefinitionMap.put("a", aBeanDefinition);
		beanDefinitionMap.put("b", bBeanDefinition);
		beanDefinitionMap.put("c", cBeanDefinition);
	}

}
