package com.filipefonseca.product.application.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProductInterface {
    UUID getId();

    String getTitle();

    String getDescription();

    BigDecimal getPrice();

    String getThumbnail();

//    List<String> getImages();

    String getSku();

    List<CategoryInterface> getCategories();

    VendorInterface getVendor();
}
