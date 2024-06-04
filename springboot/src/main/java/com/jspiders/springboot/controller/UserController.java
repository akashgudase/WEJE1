package com.jspiders.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.pojo.User;
import com.jspiders.springboot.response.ResponseStructure;
import com.jspiders.springboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/user")
	public ResponseStructure<User> addUser(@RequestBody User user) {
		User addedUser = userService.addUser(user);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (addedUser != null) {
			responseStructure.setMessage("USER ADDED");
			responseStructure.setHttpStatus(HttpStatus.CREATED);
			responseStructure.setHttpStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(addedUser);
		} else {
			responseStructure.setMessage("USER NOT ADDED");
			responseStructure.setHttpStatus(HttpStatus.BAD_REQUEST);
			responseStructure.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
		}
		return responseStructure;
	}

}
