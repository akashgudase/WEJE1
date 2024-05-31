package com.jspiders.springboot.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product_info")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, unique = false)
	private String name;
	@Column(nullable = false, unique = false)
	private String brand;
	@Column(nullable = false, unique = false)
	private double price;
	@Column(nullable = false, unique = false)
	private float rating;
	@Column(nullable = false, unique = false)
	private String category;
	@Column(nullable = true, unique = false)
	private String description;

}
