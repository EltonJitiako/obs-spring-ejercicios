package com.example.ejercicio4;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class LaptopController {

    //Attributes
    public LaptopRepository laptopRepository;

    //Constructors

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    //CRUD

    //Buscar laptops
    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {

        return laptopRepository.findAll();
    }

    //Crear en la BD
    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop) {
        return laptopRepository.save(laptop);

    }

}
