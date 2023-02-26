package com.caiopivetta6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

	@GetMapping("/style")
	public String style() {
		return "index";
	}
	
	
	
	
}
