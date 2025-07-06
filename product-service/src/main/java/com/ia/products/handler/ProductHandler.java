package com.ia.products.handler;

import com.ia.products.dto.ProductDto;
import com.ia.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductHandler {

    @Qualifier("redisCacheService")
    private final ProductService productService;


    public Mono<ServerResponse> getProductById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        return productService.getProductById(id)
                .flatMap(productDto -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(productDto))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> insertProduct(ServerRequest request) {
        return request.bodyToMono(ProductDto.class)
                .flatMap(productService::insertProduct)
                .flatMap(savedProduct -> ServerResponse.status(201)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(savedProduct));
    }
}
