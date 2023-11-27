package com.application.paymentservice.model.response;

import com.application.paymentservice.enumm.PaymentEnum;
import com.application.paymentservice.enumm.PaymentStatusEnum;
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
