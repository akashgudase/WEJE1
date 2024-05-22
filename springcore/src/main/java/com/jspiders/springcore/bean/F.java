package com.jspiders.springcore.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("prototype")
@Getter
@Setter
public class F {

	{
		System.out.println("Bean is created for F");
	}

	@Value("40")
	private int f;

}
