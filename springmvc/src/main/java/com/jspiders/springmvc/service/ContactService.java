package com.jspiders.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dao.ContactDAO;
import com.jspiders.springmvc.dto.ContactDTO;

@Component
public class ContactService {

	@Autowired
	private ContactDAO contactDAO;

	public boolean addContact(String firstName, String lastName, String email, long mobile) {
		ContactDTO contactDTO = new ContactDTO();
		contactDTO.setFirstName(firstName);
		contactDTO.setLastName(lastName);
		contactDTO.setEmail(email);
		contactDTO.setMobile(mobile);
		try {
			contactDAO.addContact(contactDTO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<ContactDTO> findAllContacts() {
		return contactDAO.findAllContacts();
	}

}
