package com.jjh.anno.importAnno.scan;

import com.jjh.anno.importAnno.ConfigurationA;
import com.jjh.anno.importAnno.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.jjh.anno.importAnno.scan")
public class ImportAnnoTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(ImportAnnoTest.class);
		Product bean =(Product) anno.getBean("product");
//		ConfigurationA bean =(ConfigurationA) anno.getBean("configurationA"); error
		Customer customer =(Customer) anno.getBean("customer");
		System.out.println(bean);
		System.out.println(customer);
	}
}
