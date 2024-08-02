package com.chintu.Springcore;

import org.springframework.stereotype.Component;


public class Alien {

	
	
	int age ;
	private Computer com;
	
 

   public Alien() {
		
		System.out.println("Constructor called");
	}  
    
	
   public Computer getCom() {
		return com;
	}

	public void setCom(Computer com) {
		this.com = com;
	}

public Alien(int age) {
	   
	   this.age = age;
	   
   }
	
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
    
	  

		
	public void compile() {
		
		System.out.println("Compiling..");
		
		com.compile();
	}
}
