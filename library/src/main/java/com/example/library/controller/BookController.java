package com.example.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.library.model.book;
import com.example.library.repository.BookRepository;
import com.example.library.service.Bookservice;

@RestController
@RequestMapping("BookC")
public class BookController {
    
	
	
	@Autowired
	Bookservice bservice;
	@Autowired
	BookRepository repo;
	
	@GetMapping("getall")
	public List<book> getall(){
		
		return bservice.getbooks();
	}
	@PostMapping("addnew")
	public book add(@RequestBody book b) {
		
		return bservice.addbooks(b);
	}
	
	@GetMapping("byid/{id}")
	public book findbyid(@PathVariable("id") int y ) {
		
		return bservice.findbyid(y);
	}

	@GetMapping("byauthor/{category}")
	public List<book> findbyauthor(@PathVariable("category") String author ) {
		
		return bservice.findbyauthor(author);
	}
	
	@PostMapping("{bookid}/borrow/{userid}")
	public book borrow(@PathVariable("bookid") int x, @PathVariable("userid") int y) {
		
		
		return bservice.borrows(x,y);
	}
}
