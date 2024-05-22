package com.jspiders.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.dto.ContactDTO;
import com.jspiders.springmvc.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(path = "/home_page", method = RequestMethod.GET)
	public String getHomePage() {
		return "home_page";
	}

	@RequestMapping(path = "/add_page", method = RequestMethod.GET)
	public String getAddPage() {
		return "add_page";
	}

	@RequestMapping(path = "/contacts_page", method = RequestMethod.GET)
	public String getContactsPage(ModelMap modelMap) {
		List<ContactDTO> contacts = contactService.findAllContacts();
		if (contacts.size() > 0) {
			modelMap.addAttribute("contacts", contacts);
		} else {
			modelMap.addAttribute("message", "CONTACTS NOT FOUND");
		}
		return "contacts_page";
	}

	@RequestMapping(path = "/delete_page", method = RequestMethod.GET)
	public String getDeletePage() {
		return "delete_page";
	}

	@RequestMapping(path = "/edit_page", method = RequestMethod.GET)
	public String getEditPage() {
		return "edit_page";
	}

	@RequestMapping(path = "/update_page", method = RequestMethod.GET)
	public String getUpdatePage() {
		return "update_page";
	}

	@RequestMapping(path = "/add_contact", method = RequestMethod.POST)
	public String addContact(@RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName, @RequestParam(name = "email") String email,
			@RequestParam(name = "mobile") long mobile, ModelMap modelMap) {
		boolean status = contactService.addContact(firstName, lastName, email, mobile);
		if (status) {
			modelMap.addAttribute("message", "CONTACT ADDED");
		} else {
			modelMap.addAttribute("message", "CONTACT NOT ADDED");
		}
		List<ContactDTO> contacts = contactService.findAllContacts();
		if (contacts.size() > 0) {
			modelMap.addAttribute("contacts", contacts);
		} else {
			modelMap.addAttribute("message", "CONTACTS NOT FOUND");
		}
		return "contacts_page";
	}

}
