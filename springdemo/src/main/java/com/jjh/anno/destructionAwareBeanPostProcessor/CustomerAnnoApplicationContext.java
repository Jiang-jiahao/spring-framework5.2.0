package com.jjh.anno.destructionAwareBeanPostProcessor;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class CustomerAnnoApplicationContext extends AnnotationConfigApplicationContext {

	public CustomerAnnoApplicationContext(Class<?>... componentClasses) {
		super(componentClasses);
	}

	@Override
	protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		//这里暂时是无法取到自己注册的bean的，该读取到BeanDefinition的步骤在该步骤的下一步
		//但是这里主类是已经注册进去的，所以这里手动将MyDestructionAwareBeanPostProcessor添加
		beanFactory.addBeanPostProcessor(new MyDestructionAwareBeanPostProcessor());
		//这里注销主类，这里是可以注销spring的一些初始化类
		DestructionAwareBeanPostProcessorTest des = (DestructionAwareBeanPostProcessorTest)beanFactory.getBean("destructionAwareBeanPostProcessorTest");
		beanFactory.destroyBean(des);
		super.postProcessBeanFactory(beanFactory);
	}
}
