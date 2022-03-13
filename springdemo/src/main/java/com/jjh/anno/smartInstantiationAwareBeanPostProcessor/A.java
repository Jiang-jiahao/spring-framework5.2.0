package com.jjh.anno.smartInstantiationAwareBeanPostProcessor;

import com.jjh.anno.circularReferences.learn.IA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A implements IA {

	public A() {
		System.out.println("new A");
	}

	@Autowired
	private B b;


	public void hello(){
		System.out.println("helloA");
	}
}
