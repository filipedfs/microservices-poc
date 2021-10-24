package com.filipefonseca.product.adapters.dtos;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.filipefonseca.product.application.domain.CategoryInterface;
import com.filipefonseca.product.application.domain.ProductInterface;

public class CategoryDto implements CategoryInterface {
    private UUID id;
    private String name;
    private String slug;
    private List<ProductInterface> products;
    
    public CategoryDto(CategoryInterface category) {
        this.id = category.getId();
        this.name = category.getName();
        this.slug = category.getSlug();
        this.products = category.getProducts();
    }

    public CategoryDto() {
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public List<ProductInterface> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInterface> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CategoryDto that = (CategoryDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name,
                that.name) && Objects.equals(slug, that.slug) && Objects.equals(products,
                that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, slug, products);
    }
}
