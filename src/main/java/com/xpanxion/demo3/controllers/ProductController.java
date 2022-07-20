package com.xpanxion.demo3.controllers;

import com.xpanxion.demo3.models.Product;
import com.xpanxion.demo3.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @GetMapping("/home")
    public List<Product> showProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/home/{id}")
    public Product showOneProduct(@PathVariable("id") int id){
        return productRepository.findById(id).get();
    }

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product){
        return this.productRepository.save(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") int id){
        Product newProduct = this.productRepository.findById(id).get();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        return this.productRepository.save(newProduct);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") int id){
        productRepository.deleteById(id);
    }

}
