package com.jjh.anno.smartInstantiationAwareBeanPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.jjh.anno.smartInstantiationAwareBeanPostProcessor")
public class SmartInstantiationAwareBeanPostProcessorTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(SmartInstantiationAwareBeanPostProcessorTest.class);
	}
}
