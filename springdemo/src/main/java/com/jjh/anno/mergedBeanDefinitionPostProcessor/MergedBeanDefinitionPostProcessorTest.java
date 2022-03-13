package com.jjh.anno.mergedBeanDefinitionPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.jjh.anno.mergedBeanDefinitionPostProcessor")
public class MergedBeanDefinitionPostProcessorTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(MergedBeanDefinitionPostProcessorTest.class);
	}
}
