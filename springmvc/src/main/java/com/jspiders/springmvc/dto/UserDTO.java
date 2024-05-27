package com.jspiders.springmvc.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user_info")
@Data
public class UserDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = false)
	private String password;

}
