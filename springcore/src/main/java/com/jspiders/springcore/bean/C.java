package com.jspiders.springcore.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class C {
	
	{
		System.out.println("Bean is created for C");
	}
	
	@Value("10")
	private int c;
	@Autowired
	private E e;

}
