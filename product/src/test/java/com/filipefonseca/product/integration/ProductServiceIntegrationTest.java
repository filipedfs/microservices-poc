package com.filipefonseca.product.integration;

import com.filipefonseca.product.adapters.dtos.ProductDto;
import com.filipefonseca.product.adapters.inbound.controllers.ProductController;
import com.filipefonseca.product.application.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration
@TestPropertySource(value = "/test.properties")
public class ProductServiceIntegrationTest {
    @Autowired
    private ProductController productController;

    @Test
    public void test() {
        // Given
        ProductDto productDto = new ProductDto();
        productDto.setTitle("Product test");
        productDto.setDescription("Product description");
        productDto.setSku("sku");
        productDto.setPrice(new BigDecimal("9.99"));

        // When
        Product savedProduct = productController.create(productDto).getBody();

        // Assert
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isNotNull();
        assertThat(savedProduct.getTitle()).isEqualTo(productDto.getTitle());
        assertThat(savedProduct.getDescription()).isEqualTo(productDto.getDescription());
        assertThat(savedProduct.getSku()).isEqualTo(productDto.getSku());
        assertThat(savedProduct.getPrice()).isEqualTo(productDto.getPrice());
    }
}
