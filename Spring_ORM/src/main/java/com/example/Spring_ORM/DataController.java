package com.example.Spring_ORM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring_ORM.Model.Employee;


@RestController
public class DataController {
	
	@Autowired
	DataRepository repository;
	
	public void execute(Model M) {
		
		M.addAttribute("welcome", "this is employee database");
		//return  "index";
	}

	@RequestMapping("/")
	public String home() {
		
		return "index";
	}
	@GetMapping("add")
	public String add(@ModelAttribute("a") Employee e) {
		
		repository.save(e);
		
		return "result" ;
	}
	
}
