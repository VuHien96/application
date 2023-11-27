package com.application.orderservice.model.dto;

import com.application.orderservice.enumm.PaymentEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class OrderDTO {
    private Long productId;
    private Long totalAmount;
    private Long quantity;
}
