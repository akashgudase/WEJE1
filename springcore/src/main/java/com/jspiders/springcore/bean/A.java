package com.jspiders.springcore.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class A {

	{
		System.out.println("Bean is created for A");
	}

	private int a;
	private B b;
	public A(int a) {
		super();
		this.a = a;
	}
	
	

}
