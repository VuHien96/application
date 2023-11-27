package com.application.orderservice.external.client;

import com.application.orderservice.exception.CustomException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "product-service/api/v1/products")
public interface ProductService {
    @PutMapping("/reduce-quantity/{id}")
    ResponseEntity<Void> reduceQuantity(@PathVariable Long id, @RequestParam Long quantity);

    default ResponseEntity<Void> fallback(Exception e) {
        throw new CustomException("Product Service is not available",
                "UNAVAILABLE",
                500);
    }

}
