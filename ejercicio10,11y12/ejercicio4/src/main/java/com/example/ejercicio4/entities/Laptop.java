package com.example.ejercicio4.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "laptops")
public class Laptop {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String cpu;
    private Integer ram;
    private Integer disk;
    private Double screen;

    //Constructor
    public Laptop() {
    }

    public Laptop(Long id, String model, String cpu, Integer ram, Integer disk, Double screen) {
        this.id = id;
        this.model = model;
        this.cpu = cpu;
        this.ram = ram;
        this.disk = disk;
        this.screen = screen;
    }

    //Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getDisk() {
        return disk;
    }

    public void setDisk(Integer disk) {
        this.disk = disk;
    }

    public Double getScreen() {
        return screen;
    }

    public void setScreen(Double screen) {
        this.screen = screen;
    }

}
