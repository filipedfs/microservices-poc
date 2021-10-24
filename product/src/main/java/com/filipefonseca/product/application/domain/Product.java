package com.filipefonseca.product.application.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Product implements ProductInterface {
    private UUID id;
    private String title;
    private String description;
    private BigDecimal price;
    private String thumbnail;
//    private List<String> images;
    private String sku;
    private List<CategoryInterface> categories;
    private Vendor vendor;



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

//    public List<String> getImages() {
//        return images;
//    }
//
//    public void setImages(List<String> images) {
//        this.images = images;
//    }

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

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", thumbnail='" + thumbnail + '\'' +
                ", sku='" + sku + '\'' +
                ", categories=" + categories +
                ", vendor=" + vendor +
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
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(title,
                product.title) && Objects.equals(description, product.description) && Objects.equals(
                price, product.price) && Objects.equals(thumbnail, product.thumbnail) && Objects.equals(
                sku, product.sku) && Objects.equals(categories, product.categories) && Objects.equals(
                vendor, product.vendor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, thumbnail, sku, categories, vendor);
    }
}
