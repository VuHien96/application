package com.application.orderservice.external.request;


import com.application.orderservice.enumm.PaymentEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class PaymentRequest {
    private Long orderId;
    private Long amount;
    private String referenceNumber;
    private PaymentEnum paymentModel;
}
