package com.example.ejercicio4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class LaptopController {

    //Attributes
    public LaptopRepository laptopRepository;

    //Constructors

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    //CRUD sobre a entidade Book

    //Buscar todos os livros
    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {

        return laptopRepository.findAll();
    }

}
