package com.jjh.anno.importAnno.scan;


import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//无需写@Component注解等，这里会在后台自动实例化执行这个selectImports，只是上下文无法获取该类
public class ConfigurationC implements ImportBeanDefinitionRegistrar {

	// 实现了ImportBeanDefinitionRegistrar，则无效，只会执行方法
//	@Bean
//	public Product product() {
//		return new Product();
//	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
		System.out.println("registerBeanDefinitions");
	}


}
