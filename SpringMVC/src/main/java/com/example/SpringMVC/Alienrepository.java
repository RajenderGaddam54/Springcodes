package com.example.SpringMVC;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import com.example.SpringMVC.Model.Employee;

public interface Alienrepository extends CrudRepository<Employee,Integer> {

}
