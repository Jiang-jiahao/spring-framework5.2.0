package com.jjh.anno.circularReferences.learn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class JdkDynimcProxy implements InvocationHandler {

	private Object target;

	public JdkDynimcProxy(Object target) {
		this.target = target;
	}

	public Object getProxy() {
		Class<?>[] interfaces = target.getClass().getInterfaces();
		ClassLoader classLoader = target.getClass().getClassLoader();
		return Proxy.newProxyInstance(classLoader, interfaces, this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("begin...");
		return method.invoke(target, args);
	}
}