package com.ia.products.service;

import com.ia.products.dto.ProductDto;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<ProductDto> getProductById(Long id);
    Mono<ProductDto> insertProduct(ProductDto productDto);
}
