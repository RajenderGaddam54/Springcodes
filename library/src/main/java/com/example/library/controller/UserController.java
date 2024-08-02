package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.User;
import com.example.library.service.Userservice;

@RestController
@RequestMapping("UserC")
public class UserController {
   
	@Autowired
	Userservice uservice;
	
	@GetMapping("allusers")
	public List<User> getalluser(){
		
		return uservice.getall();
	}
	
	@PostMapping("addusers")
	public String addusers(@RequestBody User user) {
		
		return uservice.adduser(user);
	}
	

}
