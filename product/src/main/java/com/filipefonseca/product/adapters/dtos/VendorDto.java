package com.filipefonseca.product.adapters.dtos;

import java.util.Objects;
import java.util.UUID;

import com.filipefonseca.product.application.domain.VendorInterface;

public class VendorDto implements VendorInterface {
    private UUID id;
    private String name;

    public VendorDto() {
     // Empty constructor.
    }

    public VendorDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VendorDto id(UUID id) {
        setId(id);
        return this;
    }

    public VendorDto name(String name) {
        setName(name);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VendorDto)) {
            return false;
        }
        VendorDto vendorDto = (VendorDto) o;
        return Objects.equals(id, vendorDto.id) && Objects.equals(name, vendorDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

}
