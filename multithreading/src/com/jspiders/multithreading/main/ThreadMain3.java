package com.jspiders.multithreading.main;

import com.jspiders.multithreading.threads.MyThread3;

public class ThreadMain3 {
	
	public static void main(String[] args) {
		
		MyThread3 myThread3 = new MyThread3();
		myThread3.setName("MyThread3");
		myThread3.setPriority(10);
		myThread3.start();
		
	}

}
