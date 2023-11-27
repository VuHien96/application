package com.application.orderservice.controller;

import com.application.orderservice.model.dto.OrderDTO;
import com.application.orderservice.model.request.OrderRequest;
import com.application.orderservice.model.response.OrderResponse;
import com.application.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PreAuthorize("hasAuthority('Customer')")
    @PostMapping("/place-order")
    public ResponseEntity<Object> placerOrder(@RequestBody OrderRequest request) {
        OrderDTO orderDTO = orderService.placeOrder(request);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderDetail(@PathVariable Long id) {
        OrderResponse response = orderService.getOrderDetail(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
