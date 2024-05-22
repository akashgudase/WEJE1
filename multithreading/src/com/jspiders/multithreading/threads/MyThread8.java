package com.jspiders.multithreading.threads;

public class MyThread8 extends Thread{
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println("Hello from " + this.getName());
			if(i == 3) {
				this.stop();
			}
		}
	}

}
