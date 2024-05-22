package com.jspiders.multithreading.resources;

public class Product {
	
	public boolean available;
	
	public synchronized void order() {
		System.out.println("Order is received");
		if(available) {
			System.out.println("Product is delivered");
		}else {
			System.out.println("Product is unavailable");
			System.out.println("Wait for some time..");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(available) {
				System.out.println("Product is delivered");
			}
		}
	}
	
	public synchronized void manufacture() {
		System.out.println("Product is under manufacturing process..");
		System.out.println("Product is ready");
		available = true;
		notify();
	}

}
