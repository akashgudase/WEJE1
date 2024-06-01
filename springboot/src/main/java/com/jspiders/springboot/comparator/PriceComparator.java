package com.jspiders.springboot.comparator;

import java.util.Comparator;

import com.jspiders.springboot.pojo.Product;

public class PriceComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		if (o1.getPrice() == o2.getPrice()) {
			return 0;
		} else if (o1.getPrice() > o2.getPrice()) {
			return 1;
		} else {
			return -1;
		}
	}

}
