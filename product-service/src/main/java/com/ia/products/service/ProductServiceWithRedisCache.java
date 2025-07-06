package com.ia.products.service;

import com.ia.products.dto.ProductDto;
import com.ia.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@ConditionalOnProperty(name = "CACHE_ENABLED", havingValue = "true")
@Primary
@RequiredArgsConstructor
public class ProductServiceWithRedisCache implements ProductService {
    private final ProductRepository repository;
    private final ReactiveRedisOperations<String, ProductDto> redisOps;

    private static final String CACHE_KEY_PREFIX = "product:";

    @Override
    public Mono<ProductDto> getProductById(Long id) {
        String key = CACHE_KEY_PREFIX + id;
        return redisOps.opsForValue().get(key)
                .switchIfEmpty(
                        repository.findById(id)
                                .map(ProductDto::fromEntity)
                                .flatMap(productDto -> redisOps.opsForValue().set(key, productDto).thenReturn(productDto))
                );
    }

    @Override
    public Mono<ProductDto> insertProduct(ProductDto productDto) {
        return repository.save(productDto.toEntity())
                .map(ProductDto::fromEntity)
                .flatMap(savedDto -> {
                    String key = CACHE_KEY_PREFIX + savedDto.id();
                    return redisOps.opsForValue().set(key, savedDto).thenReturn(savedDto);
                });
    }
}
