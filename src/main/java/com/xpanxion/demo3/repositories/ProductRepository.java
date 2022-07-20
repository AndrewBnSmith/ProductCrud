package com.xpanxion.demo3.repositories;

import com.xpanxion.demo3.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}


