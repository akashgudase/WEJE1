package com.jspiders.designpatterns.creational;

public class User {

	private static User user = new User();

	private User() {
		System.out.println("Constructor invoked");
	}

	public static User getObject() {
		return user;
	}

}

