package com.application.paymentservice.model.dto;

import com.application.paymentservice.enumm.PaymentEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PaymentDTO {
    private Long orderId;
    private Long amount;
    private String referenceNumber;
    private PaymentEnum paymentModel;
}
