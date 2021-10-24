package com.filipefonseca.product.adapters.inbound.controllers;

import com.filipefonseca.product.adapters.dtos.ProductDto;
import com.filipefonseca.product.application.domain.PageInfo;
import com.filipefonseca.product.application.domain.Product;
import com.filipefonseca.product.application.ports.ProductServicePort;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "product")
public class ProductController {
    private final ProductServicePort productServicePort;

    ProductController(final ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @PostMapping
    public ResponseEntity<Product> create(
            @RequestBody ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return new ResponseEntity<>(productServicePort.create(product), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Product>> findAll(
            @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC)
                    Pageable pageable) {
        final PageInfo pageInfo = new PageInfo();
        BeanUtils.copyProperties(pageable, pageInfo);
        final List<Product> productList = productServicePort.findAll(pageInfo);
        System.out.println(productList);
        return new ResponseEntity<>(new PageImpl<>(productList, pageable, productList.size()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> findById(
            @PathVariable final UUID id) {
        Optional<Product> product = productServicePort.findById(id);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(product.get());
        }
    }
}
