package com.jspiders.multithreading.threads;

import com.jspiders.multithreading.resources.MyResource2;

public class MyThread11 extends Thread {

	private MyResource2 myResource2;

	public MyThread11(MyResource2 myResource2) {
		super();
		this.myResource2 = myResource2;
	}

	@Override
	public void run() {
		synchronized (myResource2.resource2) {
			System.out.println("MyThread11 has applied a lock on Resource2");
			synchronized (myResource2.resource1) {
				System.out.println("MyThread11 has applied a lock on Resource1");
			}
		}
	}

}
