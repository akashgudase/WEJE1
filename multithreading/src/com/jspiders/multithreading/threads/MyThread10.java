package com.jspiders.multithreading.threads;

import com.jspiders.multithreading.resources.MyResource2;

public class MyThread10 extends Thread {

	private MyResource2 myResource2;

	public MyThread10(MyResource2 myResource2) {
		super();
		this.myResource2 = myResource2;
	}

	@Override
	public void run() {
		synchronized (myResource2.resource1) {
			System.out.println("MyThread10 has applied a lock on Resource1");
			synchronized (myResource2.resource2) {
				System.out.println("MyThread10 has applied a lock on Resource2");
			}
		}
	}

}
