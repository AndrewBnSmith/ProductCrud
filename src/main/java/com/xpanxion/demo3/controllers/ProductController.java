package com.xpanxion.demo3.controllers;

import com.xpanxion.demo3.models.Product;
import com.xpanxion.demo3.repositories.ProductRepository;
import com.xpanxion.demo3.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //tells the IDE that this class is a rest controller and will have endpoints(url routes)
public class ProductController {
    private ProductRepository productRepository;//inject the repository
    private ProductService productServ;

    public ProductController(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @GetMapping("/show")                  //endpoint, if you just do ("/") this is the default starting page.
    public List<Product> showProducts() {
        return productServ.getAllProducts();
    }

    @GetMapping("/show/{id}")
    public Product showOneProduct(@PathVariable("id") int id) {                       //because we pass in the id in the url, we also need to pass in the id as a parameter in the method using PathVariable.
        return productRepository.findById(id).get();
    }

    @PostMapping("/createProduct")                                                 // whenever we save to the database we use POST
    public Product createProduct(@RequestBody Product product) {                      // takes in an object of type Product, the @RequestBody allows us use the product object in JSON
        return this.productRepository.save(product);                                  //the repository handles this and saves product to the database
    }

    @PutMapping("/update/{id}")                                                    //because we pass in the id in the url, we also need to pass in the id as a parameter in the method using PathVariable.
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") int id) {
        Product newProduct = this.productRepository.findById(id).get();              // using the id parameter we passed in, we find the product and store it in a newProduct
        newProduct.setName(product.getName());                                       //set the newProducts attributes using the getters and setters we created in the Product model
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        return this.productRepository.save(newProduct);                              //saving the newProduct/updating the attributes
    }

    @DeleteMapping("/delete/{id}")                                                //because we pass in the id in the url, we also need to pass in the id as a parameter in the method using PathVariable.
    public void deleteProduct(@PathVariable("id") int id) {
        productRepository.deleteById(id);                                            //deletes the object by the id that we passed in from the url
    }

}
