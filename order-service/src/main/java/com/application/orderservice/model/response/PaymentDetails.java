package com.application.orderservice.model.response;

import com.application.orderservice.enumm.PaymentEnum;
import com.application.orderservice.enumm.PaymentStatusEnum;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PaymentDetails {
    private Long paymentId;
    private PaymentStatusEnum status;
    private PaymentEnum paymentMode;
    private Long amount;
    private Instant paymentDate;
    private Long orderId;
}
