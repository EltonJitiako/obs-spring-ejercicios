package com.example.ejercicio4;

import com.example.ejercicio4.entities.Laptop;
import com.example.ejercicio4.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio4Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejercicio4Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		//Crear
		Laptop laptop1 = new Laptop(null, "Dell Vostro", "Core i5", 8, 500, 14.0);
		Laptop laptop2 = new Laptop(null, "HP Envy", "AMD Zen3", 6, 1000, 15.5);
		//Armazenar
		repository.save(laptop1);
		repository.save(laptop2);
	}

}
