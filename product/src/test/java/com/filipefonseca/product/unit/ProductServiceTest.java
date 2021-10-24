package com.filipefonseca.product.unit;

import com.filipefonseca.product.application.domain.Product;
import com.filipefonseca.product.application.ports.ProductRepositoryPort;
import com.filipefonseca.product.application.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    private final ProductRepositoryPort productRepositoryPort = Mockito.mock(ProductRepositoryPort.class);

    private ProductService productService;

    @BeforeEach
    public void setup() {
        productService = new ProductService(productRepositoryPort);
    }

    @Test
    public void createTest() {
        Product product = new Product();
        product.setTitle("Product test");
        when(productRepositoryPort.save(any(Product.class))).then(returnsFirstArg());

        Product savedProduct = productService.create(product);
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getTitle()).isEqualTo(product.getTitle());
    }
}
