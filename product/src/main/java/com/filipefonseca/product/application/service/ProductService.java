package com.filipefonseca.product.application.service;

import com.filipefonseca.product.application.ports.ProductServicePort;
import com.filipefonseca.product.application.domain.PageInfo;
import com.filipefonseca.product.application.domain.Product;
import com.filipefonseca.product.application.ports.ProductRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductService implements ProductServicePort {

    private final ProductRepositoryPort productRepositoryPort;

    public ProductService(final ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product create(Product product) {
        return this.productRepositoryPort.save(product);
    }

    @Override
    public List<Product> findAll(PageInfo pageInfo) {
        return this.productRepositoryPort.findAll(pageInfo);
    }

    @Override
    public Optional<Product> findById(UUID productId) {
        return this.productRepositoryPort.findById(productId);
    }
}
