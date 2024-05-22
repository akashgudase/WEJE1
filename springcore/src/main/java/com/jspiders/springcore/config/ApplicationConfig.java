package com.jspiders.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.jspiders.springcore.bean.C;

@ComponentScan(basePackages = "com.jspiders.springcore")
public class ApplicationConfig {

	@Bean
	public C getBean() {
		return new C();
	}

}
