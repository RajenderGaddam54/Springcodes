package com.chintu.Springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
       
    	ApplicationContext factory = new ClassPathXmlApplicationContext("NewFile.xml");
    	
      	Alien a = (Alien) factory.getBean("alien");
    	a.setAge(9);
    	
    	System.out.println(a.getAge());
    	a.compile();
    	
    	Alien b = (Alien) factory.getBean("alien");
    	System.out.println(b.getAge());
    	b.compile();
    	
    	//if we want to set default value of age for all the objects created the we need to configure the bean of the class in xml file
    	
    	
    	
    }
}
