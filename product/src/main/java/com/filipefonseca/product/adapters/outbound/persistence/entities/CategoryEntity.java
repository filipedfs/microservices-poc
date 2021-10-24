package com.filipefonseca.product.adapters.outbound.persistence.entities;

import com.filipefonseca.product.application.domain.CategoryInterface;
import com.filipefonseca.product.application.domain.ProductInterface;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "category")
public class CategoryEntity implements CategoryInterface, Serializable {

    private static final long serialVersionUID = -1006948231599467013L;

    private UUID id;

    private String name;

    private String slug;

    private List<ProductInterface> products;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToMany(targetEntity = ProductEntity.class, mappedBy = "categories")
    public List<ProductInterface> getProducts() {
        return products;
    }

    public void setProducts(
            List<ProductInterface> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name,
                that.name) && Objects.equals(slug, that.slug) && Objects.equals(products,
                that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, slug, products);
    }
}
