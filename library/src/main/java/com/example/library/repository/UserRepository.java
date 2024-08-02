package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {

}
