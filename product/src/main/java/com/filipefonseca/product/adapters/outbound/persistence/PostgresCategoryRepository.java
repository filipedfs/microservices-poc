package com.filipefonseca.product.adapters.outbound.persistence;

import com.filipefonseca.product.adapters.outbound.persistence.entities.CategoryEntity;
import com.filipefonseca.product.application.domain.Category;
import com.filipefonseca.product.application.domain.PageInfo;
import com.filipefonseca.product.application.ports.CategoryRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PostgresCategoryRepository implements CategoryRepositoryPort {
    private final SpringDataPostgresCategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public PostgresCategoryRepository(final SpringDataPostgresCategoryRepository categoryRepository,
                                      final ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Category save(Category category) {
        final CategoryEntity categoryEntity = categoryRepository.save(modelMapper.map(category, CategoryEntity.class));
        return modelMapper.map(categoryEntity, Category.class);
    }

    @Override
    public List<Category> findAll(PageInfo pageInfo) {
        final Pageable pageable = PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize());
        return categoryRepository.findAll(pageable)
                .stream()
                .map(categoryEntity -> modelMapper.map(categoryEntity, Category.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Category> findById(UUID id) {
        final Optional<CategoryEntity> category = categoryRepository.findById(id);
        return category.map(categoryEntity -> modelMapper.map(categoryEntity, Category.class));
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(modelMapper.map(category, CategoryEntity.class));
    }

    @Override
    public void delete(UUID id) {
        categoryRepository.deleteById(id);
    }
}
