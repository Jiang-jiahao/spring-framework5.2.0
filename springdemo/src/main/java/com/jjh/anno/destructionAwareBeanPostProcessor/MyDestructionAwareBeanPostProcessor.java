package com.jjh.anno.destructionAwareBeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

//在销毁前会执行的方法
@Component
public class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {

	@Override
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
		System.out.println("invoke postProcessBeforeDestruction " + beanName);
	}

	//这里一定不是true上面的方法是不会执行的
	@Override
	public boolean requiresDestruction(Object bean) {
		return true;
	}
}
