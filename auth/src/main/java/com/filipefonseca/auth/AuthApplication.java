package com.filipefonseca.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = {"com.filipefonseca"})
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "Auth index";
    }

    @GetMapping("/home")
    public String home() {
        return "Auth home page";
    }

    @GetMapping("/other")
    public String other() {
        return "other page";
    }
}
