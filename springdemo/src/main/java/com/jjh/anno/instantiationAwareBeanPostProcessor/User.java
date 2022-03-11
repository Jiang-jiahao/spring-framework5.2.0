package com.jjh.anno.instantiationAwareBeanPostProcessor;

import org.springframework.stereotype.Component;

@Component
public class User {

	private int id;
	private String name;
	private String beanName;

	public User() {
		System.out.println("User()...");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("set " + name);
		this.name = name;
	}

	public String getBeanName() {
		return beanName;
	}





	public void start() {
		System.out.println("start()...");
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", beanName=" + beanName + "]";
	}
}