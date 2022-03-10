package com.jjh.anno.circularReferences.learn;

import com.jjh.anno.circularReferences.A;
import com.jjh.anno.circularReferences.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 一级缓存解决循环依赖问题
 * 存在的问题：在A线程实例化了A，在填充属性的时候，此时A是不完整的，当B线程执行getBean("a")方法的时候获得的对象是不完整的，会出问题
 */
public class OneSolveCircularReferencesTest {

	//bean定义缓存
	private static final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

	//一级缓存
	private static final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);


	public static void main(String[] args) throws Exception {
		newApplicationContext();
		A a = (A) getBean("a");
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
		//1、先从容器中判断是否已经创建好了Bean，存在则直接返回
		if (singletonObjects.get(beanName) != null) {
			return singletonObjects.get(beanName);
		}
		//2、实例化
		RootBeanDefinition beanDefinition = (RootBeanDefinition) beanDefinitionMap.get(beanName);
		Class<?> beanClass = beanDefinition.getBeanClass();
		Object bean = beanClass.newInstance();

		/**
		 * 实例化之后就加入到一级缓存
		 */
		singletonObjects.put(beanName, bean);


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
		//4、初始化 生命周期回调 initMethod Aware Aop创建动态代理...
		System.out.println("init " + beanName + " ...");
		//5、加入一级缓存
		singletonObjects.put(beanName, bean);
		return bean;
	}


	//加载Bean定义
	private static void loadBeanDefinitions() {
		RootBeanDefinition aBeanDefinition = new RootBeanDefinition(A.class);
		RootBeanDefinition bBeanDefinition = new RootBeanDefinition(B.class);
		beanDefinitionMap.put("a", aBeanDefinition);
		beanDefinitionMap.put("b", bBeanDefinition);
	}

}
