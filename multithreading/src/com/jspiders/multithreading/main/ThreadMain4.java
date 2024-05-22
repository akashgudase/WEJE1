package com.jspiders.multithreading.main;

import com.jspiders.multithreading.threads.MyThread4;
import com.jspiders.multithreading.threads.MyThread5;

public class ThreadMain4 {

	public static void main(String[] args) {

		MyThread4 myThread4 = new MyThread4();
		MyThread5 myThread5 = new MyThread5();

		myThread4.start();
		myThread5.start();

	}

}
