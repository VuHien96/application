package com.application.orderservice.external.response;


import com.application.orderservice.enumm.PaymentEnum;
import com.application.orderservice.enumm.PaymentStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {
    private long paymentId;
    private PaymentStatusEnum status;
    private PaymentEnum paymentMode;
    private long amount;
    private Instant paymentDate;
    private long orderId;
}
