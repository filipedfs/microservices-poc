package com.filipefonseca.product.application.domain;

import java.util.List;
import java.util.UUID;

public interface CategoryInterface {
    UUID getId();

    String getName();

    String getSlug();

    List<ProductInterface> getProducts();
}
