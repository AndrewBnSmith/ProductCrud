package com.xpanxion.demo3.models;

import javax.persistence.*;

@Entity //tells mysql that this Product class will be a table in the database
public class Product {

    @Id //tells mysql that id will be unique for each Product
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column  //tells mysql that each attribute will be a column in the table
    private String name;
    @Column
    private String description;
    @Column
    private double price;
    @ManyToOne
    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
