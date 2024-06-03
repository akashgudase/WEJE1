package com.jspiders.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.pojo.Product;
import com.jspiders.springboot.pojo.User;
import com.jspiders.springboot.response.ResponseStructure;
import com.jspiders.springboot.service.ProductService;
import com.jspiders.springboot.service.UserService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@PostMapping(path = "/product")
	public ResponseStructure<Product> addProduct(@RequestParam(name = "userId") long userId,
			@RequestBody Product product) {
		User user = userService.findUserById(userId);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (user != null && user.getRole().equals("SELLER")) {
			Product addedProduct = productService.addProduct(product);
			responseStructure.setMessage("PRODUCT ADDED");
			responseStructure.setHttpStatus(HttpStatus.CREATED);
			responseStructure.setHttpStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(addedProduct);
		} else {
			responseStructure.setMessage("INVALID USER");
			responseStructure.setHttpStatus(HttpStatus.UNAUTHORIZED);
			responseStructure.setHttpStatusCode(HttpStatus.UNAUTHORIZED.value());
		}
		return responseStructure;

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
	public ResponseStructure<List<Product>> findProductsByCategory(@PathVariable String category) {
		List<Product> products = productService.findProductsByCategory(category);
		ResponseStructure<List<Product>> responseStructure = new ResponseStructure<>();
		if (products != null) {
			responseStructure.setMessage("PRODUCTS FOUND");
			responseStructure.setHttpStatus(HttpStatus.FOUND);
			responseStructure.setHttpStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(products);
		} else {
			responseStructure.setMessage("PRODUCTS NOT FOUND");
			responseStructure.setHttpStatus(HttpStatus.NOT_FOUND);
			responseStructure.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
		}
		return responseStructure;
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
