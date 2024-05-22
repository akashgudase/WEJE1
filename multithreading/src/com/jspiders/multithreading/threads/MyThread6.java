package com.jspiders.multithreading.threads;

import com.jspiders.multithreading.resources.MyResource1;

public class MyThread6 extends Thread{
	
	private MyResource1 myResource1;
	
	public MyThread6(MyResource1 myResource1) {
		super();
		this.myResource1 = myResource1;
	}

	@Override
	public void run() {
		myResource1.message();
	}

}
