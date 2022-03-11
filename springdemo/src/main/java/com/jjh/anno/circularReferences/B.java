package com.jjh.anno.circularReferences;

import com.jjh.anno.circularReferences.learn.C;
import com.jjh.anno.circularReferences.learn.IA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {

	public B() {
		System.out.println("new B");
	}

	@Autowired
	private IA a;

//	@Autowired
//	private C c;
}
