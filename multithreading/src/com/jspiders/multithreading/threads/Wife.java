package com.jspiders.multithreading.threads;

import com.jspiders.multithreading.resources.Account;

public class Wife extends Thread{
	
	private Account account;
	
	public Wife(Account account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		
		account.deposit(2000.00);
		account.withdraw(5000.00);
		
	}

}
