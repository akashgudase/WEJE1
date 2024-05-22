package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resources.MyResource2;
import com.jspiders.multithreading.threads.MyThread10;
import com.jspiders.multithreading.threads.MyThread11;

public class ThreadMain8 {

	public static void main(String[] args) {

		MyResource2 myResource2 = new MyResource2();

		MyThread10 myThread10 = new MyThread10(myResource2);
		MyThread11 myThread11 = new MyThread11(myResource2);

		myThread10.start();
		myThread11.start();

	}

}
