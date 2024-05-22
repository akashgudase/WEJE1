package com.jspiders.multithreading.threads;

public class MyThread3 extends Thread{
	
	@Override
	public void run() {
		System.out.println("Id : " + this.getId());
		System.out.println("Name : " + this.getName());
		System.out.println("Priority : " + this.getPriority());
	}

}
