package com.filipefonseca.product.adapters.outbound.persistence.entities;

import com.filipefonseca.product.application.domain.VendorInterface;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "vendor")
public class VendorEntity implements Serializable, VendorInterface {

    private static final long serialVersionUID = -8379812185609159143L;

    private UUID id;

    private String name;

    private List<ProductEntity> products;

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

    @OneToMany(targetEntity = ProductEntity.class, mappedBy = "vendor")
    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
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
        VendorEntity that = (VendorEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, products);
    }
}
