package com.jspiders.multithreading.main;

import com.jspiders.multithreading.threads.MyThread8;

public class ThreadMain6 {

	public static void main(String[] args) {

		MyThread8 myThread8 = new MyThread8();
		myThread8.setName("MyThread8");
		myThread8.start();

	}

}
