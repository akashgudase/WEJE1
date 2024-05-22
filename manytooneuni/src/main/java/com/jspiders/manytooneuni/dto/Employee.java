package com.jspiders.manytooneuni.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee_info")
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private long mobile;
	@ManyToOne
	private Company company;

}
