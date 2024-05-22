package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcore.bean.C;
import com.jspiders.springcore.bean.D;
import com.jspiders.springcore.bean.E;
import com.jspiders.springcore.config.ApplicationConfig;

public class Main2 {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		C c = context.getBean(C.class);
		System.out.println(c);
		((AnnotationConfigApplicationContext) context).close();

		ApplicationContext context2 = new AnnotationConfigApplicationContext("com.jspiders.springcore");
		D d = context2.getBean(D.class);
		System.out.println(d);
		((AnnotationConfigApplicationContext) context2).close();

		ApplicationContext context3 = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		E e = context3.getBean(E.class);
		System.out.println(e);
		((AnnotationConfigApplicationContext) context3).close();

	}

}
