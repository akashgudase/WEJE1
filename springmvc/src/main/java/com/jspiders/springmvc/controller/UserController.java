package com.jspiders.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.dto.UserDTO;
import com.jspiders.springmvc.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/signup_page", method = RequestMethod.GET)
	public String getSignUpPage() {
		return "signup_page";
	}

	@RequestMapping(path = "/signin_page", method = RequestMethod.GET)
	public String getSignInPage() {
		return "signin_page";
	}

	@RequestMapping(path = "/add_user", method = RequestMethod.POST)
	public String addUser(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password,
			ModelMap modelMap) {
		boolean status = userService.addUser(email, password);
		if (status) {
			modelMap.addAttribute("message", "SIGNED UP");
			return "signin_page";
		} else {
			modelMap.addAttribute("message", "ERROR WHILE SIGNING UP");
			return "signup_page";
		}
	}

	@RequestMapping(path = "/check_user", method = RequestMethod.POST)
	public String findUserByEmailAndPassword(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, ModelMap modelMap, HttpSession httpSession) {
		UserDTO user = userService.findUserByEmailAndPassword(email, password);
		if (user != null) {
			httpSession.setAttribute("user", user);
			httpSession.setMaxInactiveInterval(3600);
			return "home_page";
		} else {
			modelMap.addAttribute("message", "INVALID EMAIL OR PASSWORD");
			return "signin_page";
		}
	}

	@RequestMapping(path = "/signout", method = RequestMethod.GET)
	public String signOut(HttpSession httpSession) {
		httpSession.invalidate();
		return "signin_page";
	}

	@RequestMapping(path = "/delete_user", method = RequestMethod.GET)
	public String deleteUser(ModelMap modelMap, HttpSession httpSession) {
		UserDTO user = (UserDTO) httpSession.getAttribute("user");
		if (user != null) {
			userService.deleteUser(user.getId());
			modelMap.addAttribute("message", "USER DELETED");
		}
		return "signin_page";
	}

}
