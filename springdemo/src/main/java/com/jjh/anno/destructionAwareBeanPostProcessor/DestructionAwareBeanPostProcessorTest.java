package com.jjh.anno.destructionAwareBeanPostProcessor;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.jjh.anno.destructionAwareBeanPostProcessor")
public class DestructionAwareBeanPostProcessorTest implements DisposableBean {

	public static void main(String[] args) {
		CustomerAnnoApplicationContext anno = new CustomerAnnoApplicationContext(DestructionAwareBeanPostProcessorTest.class);
	}

	@Override
	public void destroy() {
		System.out.println("DestructionAwareBeanPostProcessorTest destroy()...");
	}
}
