package com.xpanxion.demo3.repositories;

import com.xpanxion.demo3.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    List<Supplier> findAll();
}
