package com.hsoft.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "*")
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String getHomePage() {
		return "login";
	}
}
