package com.example.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.book;

@Repository
public interface BookRepository extends JpaRepository<book,Integer>{

	
	List<book> findByauthor(String author);
}
