package com.jspiders.designpatterns.creational;

public class Account {
	
	private static Account account;

	private Account() {
		System.out.println("Constructor invoked");
	}

	public static Account getObject() {
		if(account == null) {
			account = new Account();
		}
		return account;
	}

}
