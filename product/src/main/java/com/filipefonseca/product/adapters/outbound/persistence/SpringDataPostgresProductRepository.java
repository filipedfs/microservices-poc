package com.filipefonseca.product.adapters.outbound.persistence;

import com.filipefonseca.product.adapters.outbound.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataPostgresProductRepository extends JpaRepository<ProductEntity, UUID> {
}
