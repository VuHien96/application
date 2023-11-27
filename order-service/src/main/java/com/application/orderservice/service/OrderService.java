package com.application.orderservice.service;

import com.application.orderservice.model.dto.OrderDTO;
import com.application.orderservice.model.request.OrderRequest;
import com.application.orderservice.model.response.OrderResponse;

public interface OrderService {
    OrderDTO placeOrder(OrderRequest request);

    OrderResponse getOrderDetail(Long id);
}
