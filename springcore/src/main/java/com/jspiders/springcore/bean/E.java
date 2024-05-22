package com.jspiders.springcore.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class E {

	{
		System.out.println("Bean is created for E");
	}

	@Value("30")
	private int e;

}
