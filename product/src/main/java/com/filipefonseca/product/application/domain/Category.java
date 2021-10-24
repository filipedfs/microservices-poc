package com.filipefonseca.product.application.domain;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Category implements CategoryInterface {
    private UUID id;
    private String name;
    private String slug;
    private List<ProductInterface> products;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public List<ProductInterface> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInterface> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(name, category.name) && Objects.equals(slug, category.slug) && Objects.equals(products, category.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, slug, products);
    }
}
