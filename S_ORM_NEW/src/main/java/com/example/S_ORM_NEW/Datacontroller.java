package com.example.S_ORM_NEW;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Datacontroller {
    
	@Autowired
	Datarepository dr;
	
	@RequestMapping("/")
	public String execute() {
		
		return "index";
	}
	@GetMapping("getdata")
	public String get(Model m) {
		
		m.addAttribute("get", dr.findAll());
		return "result";
	}
	
	
	@PostMapping("add")
	public String add(@ModelAttribute("m") Employee e) {
		
		dr.save(e);
		return "Done";
	}
	
	@GetMapping("getone")
	public String getone(@RequestParam("id") int x, Model m) {
		
		Employee e1;
		e1 = dr.findById(x).get();
		m.addAttribute("data", e1);
		return "result";
		
	}
	@PostMapping("doupdate")
	public String doupdate(@RequestParam("id") int x, Model m) {
		
		
		Employee e1 = dr.findById(x).get();
		e1.setSalary(5000);
		dr.save(e1);
		m.addAttribute("data", e1);
		return "result";
		
	}
}
