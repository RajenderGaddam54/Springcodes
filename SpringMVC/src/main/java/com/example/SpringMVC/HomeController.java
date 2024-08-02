package com.example.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.example.SpringMVC.Model.Employee;


import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	
	@Autowired
	Alienrepository repo;
	
	
	@ModelAttribute
	public void every(Model m) {
		
		m.addAttribute("x", "How are you");
	}
	
	
	@RequestMapping("/")
	public String home() {
		
		return "index";
	}
	
	/*@RequestMapping("add")
	public String add(@RequestParam("num1") int i ,@RequestParam("num2") int j, HttpSession session) {
		
		int k = i+j;
		session.setAttribute("k",k);
		
		return "result.jsp";
	}*/
	
	// We can use ModelAndView instead of HttpSession object below is the implementation
	
	/*
	@RequestMapping("add")
	public ModelAndView view(@RequestParam("num1") int i, @RequestParam("num2") int j) {
     //@Autowired
     ModelAndView mv = new ModelAndView();
     
     
	 int k = i+j;
	 mv.setViewName("result");
	 mv.addObject("k", k);
	 return mv;
	}
	*/
	
	/*
	@RequestMapping("add")
	public String view(@RequestParam("num1") int i, @RequestParam("num2") int j,ModelMap M) {
     //@Autowired
 
	 int k = i+j;
	
	 M.addAttribute("k", k);
	 
	  return "result";
	}
	*/
	/*
	@RequestMapping("addAlien")
	
	public String view(@RequestParam("aid") int x, @RequestParam("aname") String y,Model m) {
		
		Alien a = new Alien();
		a.setAid(x);
		a.setAname(y);
		
		m.addAttribute("k",a);
		return "result";
	}
	*/
	
//@RequestMapping("addAlien")
	//@PostMapping("addAlien")
	@GetMapping("addAlien")
	public String view(@ModelAttribute ("a") Employee e) {
		
		repo.save(e);
		
		//m.addAttribute("k",a);
		return "result";
	}
	@RequestMapping("getaliens")
	public String getaliens(Model m) {
		
		m.addAttribute("result", repo.findAll());
		return "showresult";
	}
}
