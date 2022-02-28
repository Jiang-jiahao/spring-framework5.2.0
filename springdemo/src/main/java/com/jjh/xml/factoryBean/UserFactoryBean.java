package com.jjh.xml.factoryBean;

import com.jjh.xml.factoryBean.entity.User;
import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean<User> {

	@Override
	public User getObject() throws Exception {
		return new User();
	}

	@Override
	public Class<User> getObjectType() {
		return User.class;
	}
}
