package com.yourcompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // This annotation marks the class as a Spring Boot application.
public class ContactsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactsApplication.class, args); // Starts the Spring Boot application
    }
}
