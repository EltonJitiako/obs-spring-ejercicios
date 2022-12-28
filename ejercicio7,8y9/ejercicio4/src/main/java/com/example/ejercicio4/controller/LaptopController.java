package com.example.ejercicio4.controller;

import com.example.ejercicio4.entities.Laptop;
import com.example.ejercicio4.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    /***** Attributes *****/
    public LaptopRepository laptopRepository;

    /***** Constructors *****/

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    /***** CRUD *****/

    /***** Find all laptops *****/
    @GetMapping("/api/laptops")
    @ApiOperation("Find all laptops on DB")
    public List<Laptop> findAll() {

        return laptopRepository.findAll();
    }

    /***** Find laptops by ID *****/
    @GetMapping("/api/laptops/{id}")
    @ApiOperation("Find one laptop by id")
    public ResponseEntity<Laptop> findOneById(@ApiParam("Key type 'Long'") @PathVariable Long id) {

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        return laptopOpt.isPresent()? ResponseEntity.ok(laptopOpt.get()) : ResponseEntity.notFound().build();
    }

    /***** Create a new laptop *****/
    @PostMapping("/api/laptops")
    @ApiOperation("Create a new laptop on DB")
    public ResponseEntity<Laptop> create(@ApiParam("Parameter object 'laptop'") @RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {

        if(laptop.getId()!= null) { //If there is an Id, it is edit and not create

            return ResponseEntity.badRequest().build();

        }

        //Save on DB
        Laptop newLaptop = laptopRepository.save(laptop);
        return ResponseEntity.ok(newLaptop);

    }

    /***** Editing laptops *****/
    @PutMapping("/api/laptops")
    @ApiOperation("Edit a laptop on DB")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if(laptop.getId()== null) { //If there is not an Id, it is create and not edit

            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())) { //If doesn't have an Id, it is impossible to edit

            return ResponseEntity.notFound().build();
        }

        //Save on DB
        Laptop newLaptop = laptopRepository.save(laptop);
        return ResponseEntity.ok(newLaptop);

    }

    /***** Delete laptops by ID *****/
    @DeleteMapping("/api/laptops/{id}")
    @ApiOperation("Delete laptops by ID")
    public ResponseEntity<Laptop> delete(@ApiParam("Key type 'Long'") @PathVariable Long id) {

        if(!laptopRepository.existsById(id)) { //If doesn't have an Id, it is impossible to delete

            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    /***** Delete all laptops *****/
    //@ApiIgnore //Turn invisible on swagger
    @DeleteMapping("/api/laptops")
    @ApiOperation("Delete all laptops")
    public ResponseEntity<Laptop> deleteAll() {

        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();

    }

}
