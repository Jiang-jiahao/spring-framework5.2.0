package com.jjh.anno.circularReferences;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.jjh.anno.circularReferences")
public class CircularReferencesTest {
	public static void main(String[] args) {
//		AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext();
//		anno.scan("com.jjh.anno.circularReferences");
//		anno.refresh();
//		A a = (A)anno.getBean("a");
//		System.out.println(a);
		//这边传入的CircularReferencesTest.class只是为了取到该类上的@ComponentScan注解
		AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(CircularReferencesTest.class);
		A a = (A)anno.getBean("a");
		System.out.println(a);
	}
}
