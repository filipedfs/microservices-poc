package com.filipefonseca.product.adapters.dtos;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.filipefonseca.product.application.domain.CategoryInterface;
import com.filipefonseca.product.application.domain.ProductInterface;
import com.filipefonseca.product.application.domain.VendorInterface;

/**
 * Product DTO.
 */
public class ProductDto implements ProductInterface {
    private UUID id;

    @NotBlank
    private String title;

    private String description;

    @NotBlank
    private BigDecimal price;

    private String thumbnail;

//    private List<String> images;

    private String sku;

    private List<CategoryInterface> categories;

    @NotBlank
    private VendorInterface vendor;

    /**
     * Default constructor.
     */
    public ProductDto() {
      // Empty constructor.
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<CategoryInterface> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryInterface> categories) {
        this.categories = categories;
    }

    public VendorInterface getVendor() {
        return vendor;
    }

    public void setVendor(VendorInterface vendor) {
        this.vendor = vendor;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductDto)) {
            return false;
        }
        ProductDto productDto = (ProductDto) o;
        return Objects.equals(id, productDto.id) && Objects.equals(title, productDto.title) && Objects.equals(description, productDto.description) && Objects.equals(price, productDto.price) && Objects.equals(thumbnail, productDto.thumbnail) && Objects.equals(sku, productDto.sku) && Objects.equals(categories, productDto.categories) && Objects.equals(vendor, productDto.vendor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, thumbnail, sku, categories, vendor);
    }
    
}
