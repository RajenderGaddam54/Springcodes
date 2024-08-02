package com.example.library.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.library.model.User;
import com.example.library.model.book;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;

@Service
public class Bookservice {

	
	
	@Autowired
	BookRepository repo;
	@Autowired
	UserRepository urepo;
	
	public List<book> getbooks() {
		// TODO Auto-generated method stub
		System.out.println(repo.findAll().toString());
		 return repo.findAll();
	}
	
	public book addbooks(@RequestBody book b) {
		
		repo.save(b);
	
		
		return b;
	}

	public book findbyid(int y) {
		// TODO Auto-generated method stub
		book b = repo.findById(y).get();
		return b;
	}

	public List<book> findbyauthor(String author) {
		// TODO Auto-generated method stub
		
		
		return repo.findByauthor(author);
	}

	public book borrows(int x, int y) {
		
		book b = repo.findById(x).get();
		User u = urepo.findById(y).get();
		
		if(b!=null && !b.isBorrowed() && u!=null) {
			
			b.setBorrowed(true);
			b.setBorrowedby(u);
			repo.save(b);
			return b;
		}
		
		return null;
	}
	
	

	
	
}
