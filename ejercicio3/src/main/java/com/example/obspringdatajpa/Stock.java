package com.example.obspringdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stock {

    //attributs encapsulated (private)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String productName;
    private String manufacturerName;
    private Integer quantity;


    //constructor


    public Stock() {
    }

    public Stock(Long id, String productName, String manufacturerName, Integer quantity) {
        this.id = id;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.quantity = quantity;
    }

    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

