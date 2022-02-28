package com.jjh.xml.service.impl;

import com.jjh.xml.service.IWelcomeService;

public class WelcomeServiceImpl implements IWelcomeService {

	@Override
	public String sayHello(String name) {
		System.out.println("欢迎您：" + name);
		return "success";
	}
}
