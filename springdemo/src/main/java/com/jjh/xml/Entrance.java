package com.jjh.xml;

import com.jjh.xml.beanFactoryPostProcessor.BeanDefinitionFacProcessor;
import com.jjh.xml.customApplication.CustomizedApplication;
import com.jjh.xml.factoryBean.entity.User;
import com.jjh.xml.factoryBean.UserFactoryBean;
import com.jjh.xml.postProcessor.bean.Student;
import com.jjh.xml.service.IWelcomeService;
import org.springframework.beans.factory.Aware;

public class Entrance {
	public static void main(String[] args) {
		String path = "classpath:spring/spring-config.xml";
		//自定义的Application，并且自定义DocumentReader
		CustomizedApplication context = new CustomizedApplication(path);
//		context.addApplicationListener();
//		context.setAllowCircularReferences(true); //允许自动解决循环依赖，默认true
//		context.setAllowBeanDefinitionOverriding(true); //允许beanDefinition覆盖，默认是true
//		context.addBeanFactoryPostProcessor(new BeanDefinitionFacProcessor());
//		context.addBeanFactoryPostProcessor(new BeanDefinitionFacProcessor());
//		context.refresh();

//		ApplicationContext context = new FileSystemXmlApplicationContext(path);
//		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		IWelcomeService welcomeService = (IWelcomeService)context.getBean("welcomeService");
		//获取userBeanFactory类中的geiObject方法执行的结果
		User user1 = (User)context.getBean("userFactoryBean");
		User user2 = (User)context.getBean("userFactoryBean");
		//获取userBeanFactory的实例
		UserFactoryBean userFactoryBean = (UserFactoryBean)context.getBean("&userFactoryBean");
		welcomeService.sayHello("jjh");
		//获取BeanDefinitionRegistryPostProcessor注册进入的实例
		Student student = (Student)context.getBean("student");
		System.out.println(student);
		//Aware
		Aware aware = (Aware)context.getBean("testAware");
		System.out.println(aware);

	}
}
