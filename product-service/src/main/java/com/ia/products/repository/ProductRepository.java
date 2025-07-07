package com.ia.products.repository;

import com.ia.products.model.Product;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends R2dbcRepository
        <Product, Long> {
}