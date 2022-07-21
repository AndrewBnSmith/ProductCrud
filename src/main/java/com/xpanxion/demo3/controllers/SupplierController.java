package com.xpanxion.demo3.controllers;

import com.xpanxion.demo3.models.Supplier;
import com.xpanxion.demo3.repositories.SupplierRepository;
import com.xpanxion.demo3.services.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class SupplierController {

    private SupplierRepository supplierRepository;

    private SupplierService supplierService;

    public SupplierController(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    @GetMapping("/supplier/all")
        public List<Supplier> showSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/supplier/{id}")
    public Supplier showOneSupplier(@PathVariable("id") int id){
        return supplierService.getOneSupplier(id);
    }

    @PostMapping("/update/supplier/{id}")
    public Supplier updateSupplier(@RequestBody Supplier supplier, @PathVariable("id") int id){
        Supplier newSupplier = this.supplierRepository.findById(id).get();
        newSupplier.setSupplierName(supplier.getSupplierName());
        newSupplier.setContactName(supplier.getContactName());
        newSupplier.setAddress(supplier.getAddress());
        newSupplier.setCity(supplier.getCity());
        newSupplier.setPostCode(supplier.getPostCode());
        newSupplier.setCountry(supplier.getCountry());
        newSupplier.setPhone(supplier.getPhone());
        return  this.supplierService.save(newSupplier);
    }

    @DeleteMapping("/delete/supplier/{id}")                                                //because we pass in the id in the url, we also need to pass in the id as a parameter in the method using PathVariable.
    public void deleteSupplier(@PathVariable("id") int id) {
        supplierService.deleteById(id);                                            //deletes the object by the id that we passed in from the url
    }










}
