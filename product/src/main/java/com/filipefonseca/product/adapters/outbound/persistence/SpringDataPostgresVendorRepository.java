package com.filipefonseca.product.adapters.outbound.persistence;

import com.filipefonseca.product.adapters.outbound.persistence.entities.VendorEntity;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface SpringDataPostgresVendorRepository extends Repository<VendorEntity, UUID> {
}
