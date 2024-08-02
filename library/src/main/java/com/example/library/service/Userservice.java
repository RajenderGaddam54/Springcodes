package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.User;
import com.example.library.repository.UserRepository;

@Service
public class Userservice {
	
	@Autowired
	UserRepository repo;

	public List<User> getall() {
		// TODO Auto-generated method stub
		
	
		return repo.findAll();
	}

	public String adduser(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
		return "success";
	}

}
