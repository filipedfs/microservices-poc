package com.filipefonseca.product.adapters.outbound.persistence;

import com.filipefonseca.product.adapters.outbound.persistence.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataPostgresCategoryRepository extends JpaRepository<CategoryEntity, UUID> {
}