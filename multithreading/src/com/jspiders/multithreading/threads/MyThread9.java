package com.jspiders.multithreading.threads;

public class MyThread9 extends Thread {

	private String message;

	public MyThread9(String message) {
		super();
		this.message = message;
	}

	@Override
	public void run() {

		char[] arr = message.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
