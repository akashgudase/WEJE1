package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resources.Product;
import com.jspiders.multithreading.threads.Customer;
import com.jspiders.multithreading.threads.Merchant;

public class ProductMain {

	public static void main(String[] args) {

		Product product = new Product();

		Customer customer = new Customer(product);
		customer.start();

		Merchant merchant = new Merchant(product);
		merchant.start();

	}

}
