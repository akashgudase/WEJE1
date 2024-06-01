package com.jspiders.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.pojo.Product;
import com.jspiders.springboot.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(path = "/product")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@GetMapping(path = "/product")
	public Object findProductById(@RequestParam(name = "id") long id) {
		return productService.findProductById(id);
	}

	@GetMapping(path = "/products")
	public Object findAllProducts() {
		return productService.findAllProducts();
	}

	@GetMapping(path = "/products/{category}")
	public Object findProductsByCategory(@PathVariable String category) {
		return productService.findProductsByCategory(category);
	}

	@GetMapping(path = "/products/sort/rating")
	public Object sortProductsByRating() {
		return productService.sortProductsByRating();
	}

	@GetMapping(path = "/products/sort/price")
	public Object sortProductsByPrice() {
		return productService.sortProductsByPrice();
	}

	@PutMapping(path = "/product")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@DeleteMapping(path = "/product")
	public Object deleteProduct(@RequestParam(name = "id") long id) {
		return productService.deleteProduct(id);
	}

}