package com.jspiders.springcore.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class D {

	{
		System.out.println("Bean is created for D");
	}

	@Value("20")
	private int d;
	@Autowired
	private E e;

//	public D(@Autowired E e) {
//		super();
//		System.out.println("Constructor is invoked.");
//		this.e = e;
//	}

//	@Autowired
//	public void setE(E e) {
//		System.out.println("Setter is invoked.");
//		this.e = e;
//	}

}
