package com.example.RestServices.Controller;


import com.example.RestServices.Repository.DataRepository;
import com.example.RestServices.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DataController {


    @Autowired
    DataRepository repo;

    @GetMapping("all")
    public List<Product> get_all(){
        
       
        List<Product> x = new ArrayList<Product>();
        x = repo.findAll();
        return x;
    }
    
    @PostMapping("add")
    public Product add(@RequestBody Product p) {
    	
    	repo.save(p);
    	return p;
    }

    @PutMapping("update/{id}")
    public String update(@PathVariable("id") int id) {
    	
    	Product p = repo.findById(id).get();
    	p.setType("cable-wire");
    	repo.save(p);
    	return "done";
    }
    
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") int id) {
    	
    	repo.deleteById(id);
    	return "deleted";
    }

}
