package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping(path = "/")
	public String base() {
		return "Welcome to My Demo Spring Boot";
	}
	
	@GetMapping(path = "/home")
	public String home() {
		return "Welcome to My home page";
	}
	
	@GetMapping(path = "/about")
	public String about() {
		return "Welcome to My About Page";
	}
	
	@GetMapping(path = "/*")
	public String wrong() {
		return "Page Not Found";
	}
}
