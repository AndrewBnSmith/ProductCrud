package com.xpanxion.demo3.services;

import com.xpanxion.demo3.models.Product;
import com.xpanxion.demo3.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public Product save(Product productObj){
        return productRepo.save(productObj);
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product getOneProduct(int id){
        return productRepo.findById(id).orElse(null);
    }

    public void deleteById(int id){
        productRepo.deleteById(id);
    }
}
