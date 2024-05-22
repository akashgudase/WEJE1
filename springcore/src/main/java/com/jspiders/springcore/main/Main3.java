package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcore.bean.F;
import com.jspiders.springcore.config.ApplicationConfig;

public class Main3 {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		F f1 = context.getBean(F.class);
		System.out.println(f1);
		F f2 = context.getBean(F.class);
		System.out.println(f2);
		((AnnotationConfigApplicationContext) context).close();
	}

}
