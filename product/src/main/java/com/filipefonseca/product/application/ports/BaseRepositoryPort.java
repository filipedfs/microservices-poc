package com.filipefonseca.product.application.ports;

import com.filipefonseca.product.application.domain.PageInfo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseRepositoryPort<T> {
    T save(T entity);

    List<T> findAll(PageInfo pageInfo);

    Optional<T> findById(UUID id);

    void delete(T entity);

    void delete(UUID id);
}
