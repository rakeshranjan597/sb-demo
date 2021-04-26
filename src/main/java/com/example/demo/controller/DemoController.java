package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.UserEntity;

@RestController
@CrossOrigin
public class DemoController {
	
	@Autowired
	private UserDao dao;
//	
//	public void setUserDao(UserDao dao) {
//        this.dao = dao;
//    }
//	
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
	
	@GetMapping(path = "/getUser/{uid}")
	public UserEntity getUser(@PathVariable("uid") int uid) {
		return dao.getUser(uid);
	}
	
	@GetMapping(path = "/setUser")
	public String setUser() {
		return dao.setUser();
	}
	
	@GetMapping(path = "/getAllUser")
	public List<UserEntity> getAllUser() {
		return dao.getAllUser();
	}
	
	
	@GetMapping(path = "/*")
	public String wrong() {
		return "Page Not Found";
	}
	
}
