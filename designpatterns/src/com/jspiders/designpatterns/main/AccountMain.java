package com.jspiders.designpatterns.main;

import com.jspiders.designpatterns.creational.Account;

public class AccountMain {

	public static void main(String[] args) {

		Account account1 = Account.getObject();
		System.out.println(account1);
		Account account2 = Account.getObject();
		System.out.println(account2);
		Account account3 = Account.getObject();
		System.out.println(account3);
		Account account4 = Account.getObject();
		System.out.println(account4);

	}

}
