package com.jjh.xml.customApplication;

import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.w3c.dom.Element;

public class CustomizedDefaultBeanDefinitionDocumentReader extends DefaultBeanDefinitionDocumentReader {

	@Override
	protected void preProcessXml(Element root) {
		System.out.println("my preProcessXml");
		super.preProcessXml(root);
	}
}
