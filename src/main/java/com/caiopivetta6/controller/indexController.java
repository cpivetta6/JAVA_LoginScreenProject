package com.caiopivetta6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.caiopivetta6.model.UserModel;
import com.caiopivetta6.services.UserService;

@Controller
public class indexController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String index(Model model) {
		model.addAttribute("loginRequest", new UserModel());
		return "login_page";
	}
	
	@GetMapping("/register.html")
	public String register(Model model) {
		model.addAttribute("registerRequest", new UserModel());
		return "register";
	}
	
	
	@PostMapping("/register")
	public String userRegistration(@ModelAttribute UserModel user) {
		System.out.println(user.toString());
		UserModel registeredUser = userService.registerUser(user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName());
		return registeredUser == null ? "error_page" : "login_page";
	}
	
	@PostMapping("/login")
	public String userLogin(@ModelAttribute UserModel user, Model model) {
		System.out.println("loginRequest" +  user.toString());
		UserModel authenticatedUser = userService.authenticate(user.getLogin(), user.getPassword());
		
		if(authenticatedUser != null) {
			model.addAttribute("userLogin", authenticatedUser.getFirstName());
			
			return "personal_page";
		}else {
			System.out.println("is null<<<");
			return "error_page";
		}
		
	}
	
	
}
