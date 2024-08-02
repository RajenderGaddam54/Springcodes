package com.example.Spring_ORM;

import org.springframework.data.repository.CrudRepository;

import com.example.Spring_ORM.Model.Employee;

public interface DataRepository extends CrudRepository<Employee,Integer>{

}
