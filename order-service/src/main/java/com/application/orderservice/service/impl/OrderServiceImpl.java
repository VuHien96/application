package com.application.orderservice.service.impl;

import com.application.orderservice.entity.Order;
import com.application.orderservice.enumm.OrderStatusEnum;
import com.application.orderservice.exception.CustomException;
import com.application.orderservice.external.client.PaymentService;
import com.application.orderservice.external.client.ProductService;
import com.application.orderservice.external.request.PaymentRequest;
import com.application.orderservice.external.response.PaymentResponse;
import com.application.orderservice.external.response.ProductResponse;
import com.application.orderservice.model.dto.OrderDTO;
import com.application.orderservice.model.mapper.OrderMapper;
import com.application.orderservice.model.request.OrderRequest;
import com.application.orderservice.model.response.OrderResponse;
import com.application.orderservice.repository.OrderRepository;
import com.application.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductService productService;
    private final PaymentService paymentService;
    private final RestTemplate restTemplate;

    @Override
    public OrderDTO placeOrder(OrderRequest request) {
        log.info("Start placeOrder with param [{}]", request);
        // Order -> save the data with status order created
        // Product -> Block product (reduce the quantity)
        // Payment service -> Payment -> Success -> Complete, Else Canceled
        productService.reduceQuantity(request.getProductId(), request.getQuantity());
        var order = Order.builder()
                .productId(request.getProductId())
                .orderStatus(OrderStatusEnum.CREATED)
                .orderDate(Instant.now())
                .quantity(request.getQuantity())
                .amount(request.getTotalAmount())
                .build();
        orderRepository.save(order);
        log.info("Calling payment service to complete the payment");
        var paymentRequest = PaymentRequest.builder()
                .orderId(order.getId())
                .paymentModel(request.getPayment())
                .amount(request.getTotalAmount())
                .build();
        OrderStatusEnum orderStatus;
        try {
            paymentService.doPayment(paymentRequest);
            log.info("Payment done Successfully. Changing the Oder status to PLACED");
            orderStatus = OrderStatusEnum.SUCCESS;
        } catch (Exception e) {
            log.error("Error occurred in payment. Changing order status to PAYMENT_FAILED");
            orderStatus = OrderStatusEnum.FAIL;

        }
        order.setOrderStatus(orderStatus);
        orderRepository.save(order);

        log.info("End placeOrder with id [{}]", order.getId());
        return orderMapper.mapToOrderDTO(order);
    }

    @Override
    public OrderResponse getOrderDetail(Long id) {
        log.info("Get order details for order id [{}]", id);
        var order = orderRepository.findById(id).orElseThrow(() -> new CustomException("Order not found for the order id " + id, "NOT_FOUND", 404));
        log.info("Invoking Product service to fetch the product for id: {}", order.getProductId());
        var productResponse
                = restTemplate.getForObject(
                "http://product-service/api/v1/products/" + order.getProductId(),
                ProductResponse.class
        );

        var response = restTemplate.getForObject("http://payment-service/api/v1/payments/order/" + order.getId(),
                PaymentResponse.class);

        return orderMapper.mapToOrderResponse(order, orderMapper.mapToProductDetail(productResponse), orderMapper.mapToPaymentDetail(response));
    }
}
