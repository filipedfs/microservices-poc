package com.filipefonseca.product.adapters.configuration;

import com.filipefonseca.product.ProductApplication;
import com.filipefonseca.product.application.ports.ProductRepositoryPort;
import com.filipefonseca.product.application.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ProductApplication.class)
public class BeanConfiguration {
    @Bean
    ProductService productService(ProductRepositoryPort repository) {
        return new ProductService(repository);
    }
}
