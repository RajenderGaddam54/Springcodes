package com.example.RestServices.Repository;

import com.example.RestServices.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Product,Integer> {
}
