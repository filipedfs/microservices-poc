package com.filipefonseca.product.application.ports;

import com.filipefonseca.product.application.domain.PageInfo;
import com.filipefonseca.product.application.domain.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductServicePort {
    Product create(Product product);

    List<Product> findAll(PageInfo pageInfo);

    Optional<Product> findById(UUID productId);
}
