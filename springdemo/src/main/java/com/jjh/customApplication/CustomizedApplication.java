package com.jjh.customApplication;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 自定义applicationContext，设置自定义的reader
 */
public class CustomizedApplication extends FileSystemXmlApplicationContext {

	public CustomizedApplication(String configLocation) throws BeansException {
		super(new String[] {configLocation}, true, null);
	}
	@Override
	protected void initBeanDefinitionReader(XmlBeanDefinitionReader reader) {
		reader.setDocumentReaderClass(CustomizedDefaultBeanDefinitionDocumentReader.class);
		super.initBeanDefinitionReader(reader);
	}
}
