package com.filipefonseca.product.adapters.inbound.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping
    final String index() {
        return "Product service initial page";
    }
}
