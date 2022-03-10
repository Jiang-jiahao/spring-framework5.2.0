package com.jjh.anno.circularReferences.learn;

import com.jjh.anno.circularReferences.A;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;


public class JdkProxyBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

	@Override
	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
		if (bean instanceof A) {
			JdkDynimcProxy jdkDynimcProxy = new JdkDynimcProxy(bean);
			return jdkDynimcProxy.getProxy();
		}
		return bean;
	}
}
