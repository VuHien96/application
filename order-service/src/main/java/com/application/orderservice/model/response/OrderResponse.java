package com.application.orderservice.model.response;

import com.application.orderservice.enumm.OrderStatusEnum;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class OrderResponse {
    private Long orderId;
    private Instant orderDate;
    private OrderStatusEnum orderStatus;
    private Long amount;
    private ProductDetails productDetails;
    private PaymentDetails paymentDetails;
}
