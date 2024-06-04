package com.jspiders.springboot.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springboot.comparator.PriceComparator;
import com.jspiders.springboot.comparator.RatingComparator;
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

	public List<Product> findProductsByCategory(String category) {
		List<Product> products = productRepository.findProductsByCategory(category);
		if (products.size() > 0) {
			return products;
		} else {
			return null;
		}
	}

	public Object findAllProducts() {
		List<Product> products = productRepository.findAll();
		if (products.size() > 0) {
			return products;
		} else {
			return "NO PRODUCTS FOUND";
		}
	}

	public Object sortProductsByRating() {
		List<Product> products = productRepository.findAll();
		if (products.size() > 0) {
			Collections.sort(products, new RatingComparator());
			return products;
		} else {
			return "NO PRODUCTS FOUND";
		}

	}

	public Object sortProductsByPrice() {
		List<Product> products = productRepository.findAll();
		if (products.size() > 0) {
			Collections.sort(products, new PriceComparator());
			return products;
		} else {
			return "NO PRODUCTS FOUND";
		}
	}

	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	public Object deleteProduct(long id) {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			Product product = optional.get();
			productRepository.delete(product);
			return product;
		} else {
			return "PRODUCT NOT FOUND";
		}
	}

}
