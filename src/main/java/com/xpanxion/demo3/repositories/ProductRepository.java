package com.xpanxion.demo3.repositories;

import com.xpanxion.demo3.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAll();
}


