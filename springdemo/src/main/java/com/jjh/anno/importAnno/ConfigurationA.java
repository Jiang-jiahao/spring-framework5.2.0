package com.jjh.anno.importAnno;


import org.springframework.context.annotation.Bean;

//此时的配置类是不会加载到beanDefinition中的，是不被扫描到的(加不加Component都一样)，但是它下面的Bean是可以读取的到的
public class ConfigurationA {

	@Bean
	public Product product() {
		return new Product();
	}
}
