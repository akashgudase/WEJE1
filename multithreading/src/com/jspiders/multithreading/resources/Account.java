package com.jspiders.multithreading.resources;

public class Account {
	
	private double accountBalance;
	
	public Account(double accountBalance) {
		super();
		this.accountBalance = accountBalance;
	}

	public synchronized void deposit(double amount) {
		System.out.println("Amount of rupees " + amount + " is credited.");
		accountBalance += amount;
		System.out.println("Current account balance is " + accountBalance);
	}
	
	public synchronized void withdraw(double amount) {
		System.out.println("Amount of rupees " + amount + " is debited.");
		accountBalance -= amount;
		System.out.println("Current account balance is " + accountBalance);
	}

}
