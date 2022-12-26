package com.example.obspringdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringdatajpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObSpringdatajpaApplication.class, args);
		StockRepository repository = context.getBean(StockRepository.class);


		//Starting the stock stuffs
		Stock boli = new Stock(null, "boligrafo 2.0", "BIC", 1000);
		Stock lapis = new Stock(null, "lapis 1.0", "FaberCastell", 850);
		//Save on DB
		repository.save(boli);
		repository.save(lapis);


		//Recover from DB
		System.out.println(repository.findAll());
	}

}
