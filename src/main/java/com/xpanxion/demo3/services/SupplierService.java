package com.xpanxion.demo3.services;

import com.xpanxion.demo3.models.Product;
import com.xpanxion.demo3.models.Supplier;
import com.xpanxion.demo3.repositories.ProductRepository;
import com.xpanxion.demo3.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier save(Supplier supplierObj){
        return supplierRepository.save(supplierObj);
    }

    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    public Supplier getOneSupplier(int id){
        return supplierRepository.findById(id).orElse(null);
    }

    public void deleteById(int id){
        supplierRepository.deleteById(id);
    }
}

