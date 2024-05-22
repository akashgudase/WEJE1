package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.bean.A;
import com.jspiders.springcore.bean.B;

public class Main1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationConfig.xml");
		A a2 = (A) context.getBean("a2");
		System.out.println(a2);
		A a3 = (A) context.getBean("a3");
		System.out.println(a3);
		B b = context.getBean(B.class);
		System.out.println(b);
		A a1 = (A) context.getBean("a1");
		System.out.println(a1);
		((ClassPathXmlApplicationContext) context).close();
	}

}
