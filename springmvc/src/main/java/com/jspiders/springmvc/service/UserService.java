package com.jspiders.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dao.UserDAO;
import com.jspiders.springmvc.dto.UserDTO;

@Component
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public boolean addUser(String email, String password) {
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(email);
		userDTO.setPassword(password);
		try {
			userDAO.addUser(userDTO);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public UserDTO findUserByEmailAndPassword(String email, String password) {
		try {
			return userDAO.findUserByEmailAndPassword(email, password);
		} catch (Exception e) {
			return null;
		}
	}

	public UserDTO deleteUser(int id) {
		return userDAO.deleteUser(id);
	}

}
