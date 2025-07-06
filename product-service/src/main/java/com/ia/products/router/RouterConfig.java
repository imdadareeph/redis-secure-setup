package com.ia.products.router;

import com.ia.products.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<?> productRoutes(ProductHandler handler) {
        return route(GET("/product/{id}"), handler::getProductById)
                .andRoute(POST("/products"), handler::insertProduct);
    }
}
