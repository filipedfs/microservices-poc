package com.filipefonseca.product.adapters.outbound.persistence;

import com.filipefonseca.product.adapters.outbound.persistence.entities.ProductEntity;
import com.filipefonseca.product.application.domain.PageInfo;
import com.filipefonseca.product.application.domain.Product;
import com.filipefonseca.product.application.ports.ProductRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Primary
public class PostgresProductRepository implements ProductRepositoryPort {
    private final SpringDataPostgresProductRepository productRepository;
    private final ModelMapper modelMapper;

    public PostgresProductRepository(final SpringDataPostgresProductRepository productRepository,
                                     final ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productRepository.save(modelMapper.map(product, ProductEntity.class));
        return modelMapper.map(productEntity, Product.class);
    }

    @Override
    public List<Product> findAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize());
        return productRepository.findAll(pageable)
                .stream()
                .map(productEntity -> modelMapper.map(productEntity, Product.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(UUID id) {
        Optional<ProductEntity> emailEntity = productRepository.findById(id);
        return emailEntity.map(entity -> modelMapper.map(entity, Product.class));
    }

    @Override
    public void delete(Product entity) {
        productRepository.delete(modelMapper.map(entity, ProductEntity.class));
    }

    @Override
    public void delete(UUID id) {
         productRepository.deleteById(id);
    }
}
