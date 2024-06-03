package com.jspiders.springboot.response;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<T> {

	private String message;
	private HttpStatus httpStatus;
	private int httpStatusCode;
	private T data;

}
