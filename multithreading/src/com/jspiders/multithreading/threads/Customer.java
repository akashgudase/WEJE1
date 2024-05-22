package com.jspiders.multithreading.threads;

import com.jspiders.multithreading.resources.Product;

public class Customer extends Thread {

	private Product product;

	public Customer(Product product) {
		super();
		this.product = product;
	}

	@Override
	public void run() {
		product.order();
	}

}
