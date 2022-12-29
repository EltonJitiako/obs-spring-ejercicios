package com.example.ejercicio4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/html")
    public String html() {

        return """
                                
                <!doctype html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                  </head>
                  <body>
                    <h1 style="background-color:powderblue;">
                        Hola ejercicio4!
                    </h1>
                  </body>
                </html>
                                
                """;

    }

}
