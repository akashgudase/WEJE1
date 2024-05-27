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
			return false;
		}
	}

	public List<ContactDTO> findAllContacts() {
		return contactDAO.findAllContacts();
	}

	public ContactDTO deleteContact(int id) {
		return contactDAO.deleteContact(id);
	}

	public ContactDTO findContactById(int id) {
		return contactDAO.findContactById(id);
	}

	public boolean updateContact(int id, String firstName, String lastName, String email, long mobile) {
		try {
			contactDAO.updateContact(id, firstName, lastName, email, mobile);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
