package com.ia.products.dto;

import com.ia.products.model.Product;

public record ProductDto(Long id, String description, double price, int quantityAvailable) {
    public static ProductDto fromEntity(Product product) {
        return new ProductDto(
                product.getId(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantityAvailable()
        );
    }

    public Product toEntity() {
        return new Product(id, description, price, quantityAvailable);
    }
}
