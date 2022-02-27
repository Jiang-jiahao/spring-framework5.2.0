package com.jjh.postProcessor;

import com.jjh.postProcessor.bean.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;

//用来向容器中添加自定义的BeanDefinition

public class CustomizedBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	//主要实现这个
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		Class<Student> studentClass = Student.class;
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(studentClass);
		GenericBeanDefinition rawBeanDefinition = (GenericBeanDefinition)beanDefinitionBuilder.getRawBeanDefinition();
		//设置beanDefinition属性
//		rawBeanDefinition.setLazyInit(true);
		registry.registerBeanDefinition("student",rawBeanDefinition);
	}


	//这个是BeanFactoryPostProcessor的方法
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}
