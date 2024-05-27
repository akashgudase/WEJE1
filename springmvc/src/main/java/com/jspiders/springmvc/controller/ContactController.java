package com.jspiders.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.dto.ContactDTO;
import com.jspiders.springmvc.dto.UserDTO;
import com.jspiders.springmvc.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(path = "/home_page", method = RequestMethod.GET)
	public String getHomePage(HttpSession httpSession) {
		UserDTO user = (UserDTO) httpSession.getAttribute("user");
		if (user != null) {
			return "home_page";
		} else {
			return "signin_page";
		}
	}

	@RequestMapping(path = "/add_page", method = RequestMethod.GET)
	public String getAddPage(HttpSession httpSession) {
		UserDTO user = (UserDTO) httpSession.getAttribute("user");
		if (user != null) {
			return "add_page";
		} else {
			return "signin_page";
		}
	}

	@RequestMapping(path = "/contacts_page", method = RequestMethod.GET)
	public String getContactsPage(ModelMap modelMap, HttpSession httpSession) {
		UserDTO user = (UserDTO) httpSession.getAttribute("user");
		if (user != null) {
			List<ContactDTO> contacts = contactService.findAllContacts();
			if (contacts.size() > 0) {
				modelMap.addAttribute("contacts", contacts);
			} else {
				modelMap.addAttribute("message", "CONTACTS NOT FOUND");
			}
			return "contacts_page";
		} else {
			return "signin_page";
		}
	}

	@RequestMapping(path = "/delete_page", method = RequestMethod.GET)
	public String getDeletePage(ModelMap modelMap, HttpSession httpSession) {
		UserDTO user = (UserDTO) httpSession.getAttribute("user");
		if (user != null) {
			List<ContactDTO> contacts = contactService.findAllContacts();
			if (contacts.size() > 0) {
				modelMap.addAttribute("contacts", contacts);
			} else {
				modelMap.addAttribute("message", "CONTACTS NOT FOUND");
			}
			return "delete_page";
		} else {
			return "signin_page";
		}
	}

	@RequestMapping(path = "/edit_page", method = RequestMethod.GET)
	public String getEditPage(ModelMap modelMap, HttpSession httpSession) {
		UserDTO user = (UserDTO) httpSession.getAttribute("user");
		if (user != null) {
			List<ContactDTO> contacts = contactService.findAllContacts();
			if (contacts.size() > 0) {
				modelMap.addAttribute("contacts", contacts);
			} else {
				modelMap.addAttribute("message", "CONTACTS NOT FOUND");
			}
			return "edit_page";
		} else {
			return "signin_page";
		}
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

	@RequestMapping(path = "/delete_contact", method = RequestMethod.GET)
	public String deleteContact(@RequestParam(name = "id") int id, ModelMap modelMap) {
		ContactDTO contact = contactService.deleteContact(id);
		if (contact != null) {
			modelMap.addAttribute("message", "CONTACT DELETED");
		} else {
			modelMap.addAttribute("message", "CONTACT NOT FOUND");
		}
		List<ContactDTO> contacts = contactService.findAllContacts();
		if (contacts.size() > 0) {
			modelMap.addAttribute("contacts", contacts);
		} else {
			modelMap.addAttribute("message", "CONTACTS NOT FOUND");
		}
		return "delete_page";
	}

	@RequestMapping(path = "/edit_contact", method = RequestMethod.GET)
	public String editContact(@RequestParam(name = "id") int id, ModelMap modelMap) {
		ContactDTO contact = contactService.findContactById(id);
		if (contact != null) {
			modelMap.addAttribute("contact", contact);
			return "update_page";
		} else {
			modelMap.addAttribute("message", "CONTACT NOT FOUND");
			List<ContactDTO> contacts = contactService.findAllContacts();
			if (contacts.size() > 0) {
				modelMap.addAttribute("contacts", contacts);
			} else {
				modelMap.addAttribute("message", "CONTACTS NOT FOUND");
			}
			return "edit_page";
		}

	}

	@RequestMapping(path = "/update_contact", method = RequestMethod.POST)
	public String updateContact(@RequestParam(name = "id") int id, @RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName, @RequestParam(name = "email") String email,
			@RequestParam(name = "mobile") long mobile, ModelMap modelMap) {
		boolean status = contactService.updateContact(id, firstName, lastName, email, mobile);
		if (status) {
			modelMap.addAttribute("message", "CONTACT UPDATED");
		} else {
			modelMap.addAttribute("message", "CONTACT NOT UPDATED");
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
