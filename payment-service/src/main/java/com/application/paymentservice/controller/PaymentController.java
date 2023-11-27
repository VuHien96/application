package com.application.paymentservice.controller;

import com.application.paymentservice.model.dto.PaymentDTO;
import com.application.paymentservice.model.request.PaymentRequest;
import com.application.paymentservice.model.response.PaymentResponse;
import com.application.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    ResponseEntity<Object> doPayment(@RequestBody PaymentRequest request) {
        PaymentDTO paymentDTO = paymentService.doPayment(request);
        return new ResponseEntity<>(paymentDTO, HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentDetailsByOrderId(@PathVariable Long orderId) {
        return new ResponseEntity<>(
                paymentService.getPaymentDetailsByOrderId(orderId),
                HttpStatus.OK
        );
    }
}
