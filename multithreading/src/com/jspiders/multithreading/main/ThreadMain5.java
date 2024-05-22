package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resources.MyResource1;
import com.jspiders.multithreading.threads.MyThread6;
import com.jspiders.multithreading.threads.MyThread7;

public class ThreadMain5 {

	public static void main(String[] args) throws InterruptedException {

		MyResource1 myResource1 = new MyResource1();

		MyThread6 myThread6 = new MyThread6(myResource1);
		myThread6.setName("MyThread6");

		MyThread7 myThread7 = new MyThread7(myResource1);
		myThread7.setName("MyThread7");

		myThread6.start();
		myThread6.join();
		
		myThread7.start();

	}

}
