package com.filipefonseca.product.adapters.outbound.persistence.entities;

import com.filipefonseca.product.application.domain.CategoryInterface;
import com.filipefonseca.product.application.domain.ProductInterface;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "product")
public class ProductEntity implements ProductInterface, Serializable {

    private static final long serialVersionUID = 6127098298153371376L;
    private UUID id;
    private String title;
    private String description;
    private BigDecimal price;
    private String thumbnail;
//    private List<String> images;
    private String sku;
    private List<CategoryInterface> categories;
    private VendorEntity vendor;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

//    @Override
//    @Column(columnDefinition = "jsonb")
//    @Convert(converter = StringListConverter.class)
//    public List<String> getImages() {
//        return images;
//    }

//    public void setImages(List<String> images) {
//        this.images = images;
//    }

    @Override
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @ManyToMany(targetEntity = CategoryEntity.class)
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    @Override
    public List<CategoryInterface> getCategories() {
        return categories != null ? categories : new ArrayList<>();
    }

    public void setCategories(List<CategoryInterface> categories) {
        this.categories = categories;
    }

    @Override
    @ManyToOne(targetEntity = VendorEntity.class)
    public VendorEntity getVendor() {
        return vendor;
    }

    public void setVendor(VendorEntity vendor) {
        this.vendor = vendor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title,
                that.title) && Objects.equals(description, that.description) && Objects.equals(price,
                that.price) && Objects.equals(thumbnail, that.thumbnail) && Objects.equals(sku,
                that.sku) && Objects.equals(categories, that.categories) && Objects.equals(vendor,
                that.vendor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, thumbnail, sku, categories, vendor);
    }
}
