package com.jspiders.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.springboot.pojo.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findProductsByCategory(String category);

}
