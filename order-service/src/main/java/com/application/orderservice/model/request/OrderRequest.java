package com.application.orderservice.model.request;

import com.application.orderservice.enumm.PaymentEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class OrderRequest {
    private Long productId;
    private Long totalAmount;
    private Long quantity;
    private PaymentEnum payment;
}
