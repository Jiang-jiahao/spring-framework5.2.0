package com.jjh.anno.instantiationAwareBeanPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.jjh.anno.instantiationAwareBeanPostProcessor")
public class InstantiationAwareBeanPostProcessorTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(InstantiationAwareBeanPostProcessorTest.class);
		User user = (User)anno.getBean("user");
		user.start();
	}
}
