package com.caiopivetta6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.caiopivetta6.model.User;

@Controller
public class indexController {

	@GetMapping("/main")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register.html")
	public String register() {
		return "register";
	}
	
	
	@PostMapping("/register")
	public String userRegistration(@ModelAttribute User user) {
		System.out.println(user.toString());
		return "index";
	}
	
	
	
}
