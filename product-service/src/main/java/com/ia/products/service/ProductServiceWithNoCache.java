package com.ia.products.service;

import com.ia.products.dto.ProductDto;
import com.ia.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceWithNoCache implements ProductService {
    private final ProductRepository repository;

    @Override
    public Mono<ProductDto> getProductById(Long id) {
        return repository.findById(id)
                .map(ProductDto::fromEntity);
    }

    @Override
    public Mono<ProductDto> insertProduct(ProductDto productDto) {
        return repository.save(productDto.toEntity())
                .map(ProductDto::fromEntity);
    }
}