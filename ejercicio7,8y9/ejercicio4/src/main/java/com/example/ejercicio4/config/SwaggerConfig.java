package com.example.ejercicio4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 *
 * http://localhost:8081/swagger-ui/
 *
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails() {
        return new ApiInfo("Ejercicio 7, 8 y 9",
                "Ejercicios de Spring Boot",
                "1.0",
                "www.example.com",
                new Contact("Elton", "www.elton.com", "elton@example.com"),
                "MIT",
                "www.example.com",
                Collections.emptyList());
    }

}

