package com.jjh.anno.importAnno.scan;


import com.jjh.anno.importAnno.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//无需写@Component注解等，这里会在后台自动实例化执行这个selectImports，只是上下文无法获取该类
public class ConfigurationB implements ImportSelector {

// 实现了ImportSelector，则无效，只会执行方法
//	@Bean
//	public Product product() {
//		return new Product();
//	}

	//这个也是springboot自动装配的实现原理
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//这里返回的是配置类的全限定名，就会读取配置类的属性
		String[] str = {"com.jjh.anno.importAnno.ConfigurationA"};
		System.out.println(str);
		return str;
	}
}
