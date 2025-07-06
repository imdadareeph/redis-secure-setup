package com.ia.products.config;

import com.ia.products.dto.ProductDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public ReactiveRedisOperations<String, ProductDto> redisOperations(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<ProductDto> serializer = new Jackson2JsonRedisSerializer<>(ProductDto.class);
        
        RedisSerializationContext.RedisSerializationContextBuilder<String, ProductDto> builder = 
            RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, ProductDto> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }
}