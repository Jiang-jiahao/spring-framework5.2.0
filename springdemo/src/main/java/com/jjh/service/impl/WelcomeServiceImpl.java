package com.jjh.service.impl;

import com.jjh.service.IWelcomeService;

public class WelcomeServiceImpl implements IWelcomeService {

	@Override
	public String sayHello(String name) {
		System.out.println("欢迎您：" + name);
		return "success";
	}
}
