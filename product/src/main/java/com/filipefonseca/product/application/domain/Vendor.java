package com.filipefonseca.product.application.domain;

import java.util.Objects;
import java.util.UUID;

public class Vendor implements VendorInterface {
    private UUID id;
    private String name;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vendor vendor = (Vendor) o;
        return Objects.equals(id, vendor.id) && Objects.equals(name, vendor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
