package com.application.orderservice.external.client;

import com.application.orderservice.exception.CustomException;
import com.application.orderservice.external.request.PaymentRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "payment-service/api/v1/payments")
public interface PaymentService {

    @PostMapping
    ResponseEntity<Object> doPayment(@RequestBody PaymentRequest request);

    default ResponseEntity<Long> fallback(Exception e) {
        throw new CustomException("Payment Service is not available",
                "UNAVAILABLE",
                500);
    }
}
