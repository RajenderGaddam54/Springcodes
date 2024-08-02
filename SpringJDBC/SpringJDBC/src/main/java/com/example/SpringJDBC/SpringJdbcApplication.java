package com.example.SpringJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.SpringJDBC.Repository.AlienRepository;
import com.example.SpringJDBC.model.Alien;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		
		Alien a = context.getBean(Alien.class);
		
		a.setId(101);
		a.setName("chintu");
		a.setTech("java");
		
		AlienRepository repo = context.getBean(AlienRepository.class);
		repo.add_alien(a);
		System.out.println(repo.getall());
		 
	}

}
