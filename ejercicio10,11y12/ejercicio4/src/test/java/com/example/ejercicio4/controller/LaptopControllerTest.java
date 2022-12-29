/*package com.example.ejercicio4.controller;

import com.example.ejercicio4.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.http.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;


    @BeforeEach
    void setUp() {

        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);

    }

    @DisplayName("Try to find for all laptops in an empty list")
    @Test
    @Order(1)
    void notFindAll() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(0, response.getBody().length);

    }

    @DisplayName("Try to find a laptops with a non-existent id")
    @Test
    @Order(2)
    void notFindOneById() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/laptops/26", Laptop.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }

    @DisplayName("Try to create a laptop")
    @Test
    @Order(3)
    void create() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """ 
                {
                    "model": "Lenovo ThinkPad",
                    "cpu": "Core i7",
                    "ram": 12,
                    "disk": 2000,
                    "screen": 14.2
                }
                    """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @DisplayName("Try to find for all laptops")
    @Test
    @Order(4)
    void findAll() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertNotEquals(0, response.getBody().length);

    }

    @DisplayName("Try to find a laptops with a existent id")
    @Test
    @Order(5)
    void findOneById() {

        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @DisplayName("Try to create a laptops with an id")
    @Test
    @Order(6)
    void notCreate() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """  
                {
                    "id": 1,
                    "model": "Lenovo ThinkPad -2",
                    "cpu": "Core i7 - 2",
                    "ram": 12,
                    "disk": 2000,
                    "screen": 14.2
                }  
                    """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    }

    @DisplayName("Try to edit a laptop")
    @Test
    @Order(7)
    void update() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """  
                {
                    "id": 1,
                    "model": "Lenovo ThinkPad -2",
                    "cpu": "Core i7 - 2",
                    "ram": 12,
                    "disk": 2000,
                    "screen": 14.2
                }
                    """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.PUT, request, Laptop.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @DisplayName("Try to edit a laptop without an existent id")
    @Test
    @Order(8)
    void notUpdate() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """ 
                {
                    "model": "Lenovo ThinkPad -2",
                    "cpu": "Core i7 - 2",
                    "ram": 12,
                    "disk": 2000,
                    "screen": 14.2
                }
                    """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.PUT, request, Laptop.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    }

    @DisplayName("Try to edit a laptop with a non-existent id")
    @Test
    @Order(9)
    void notValidIdUpdate() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """ 
                {
                    "id": 26,
                    "model": "Lenovo ThinkPad -2",
                    "cpu": "Core i7 - 2",
                    "ram": 12,
                    "disk": 2000,
                    "screen": 14.2
                }
                    """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.PUT, request, Laptop.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }

    @DisplayName("Try to delete a laptop with a non-existent id")
    @Test
    @Order(10)
    void notDelete() {

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops/26", HttpMethod.DELETE, null, Laptop.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }

    @DisplayName("Try to delete a laptop with a existent id")
    @Test
    @Order(11)
    void delete() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """ 
                {
                    "model": "Lenovo ThinkPad -2",
                    "cpu": "Core i7- 2",
                    "ram": 12,
                    "disk": 2000,
                    "screen": 14.2
                }
                    """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);


        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops/2", HttpMethod.DELETE, null, Laptop.class);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }

    @DisplayName("Delete all laptops")
    @Test
    void deleteAll() {

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.DELETE, null, Laptop.class);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}*/