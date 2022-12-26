package org.example;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    //attribute
    NotificationService saludo;

    //method
    public UserService(NotificationService saludo) {

        this.saludo = saludo;

    }

}
