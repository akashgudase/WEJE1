package com.jspiders.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springboot.pojo.Product;
import com.jspiders.springboot.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public Object findProductById(long id) {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return "PRODUCT NOT FOUND";
		}

	}

	public Object findProductsByCategory(String category) {
		List<Product> products = productRepository.findProductsByCategory(category);
		if (products.size() > 0) {
			return products;
		} else {
			return "NO MATCH FOUND";
		}
	}

}
