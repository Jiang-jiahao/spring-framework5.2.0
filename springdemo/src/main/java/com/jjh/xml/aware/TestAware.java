package com.jjh.xml.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

// 实现了ApplicationContextAware就可以获取到对应的application来使用，
// 实现EnvironmentAware则可以获取到Environment来使用
public class TestAware implements ApplicationContextAware, EnvironmentAware {

	//用来接收
	private ApplicationContext applicationContext;
	private Environment environment;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}
