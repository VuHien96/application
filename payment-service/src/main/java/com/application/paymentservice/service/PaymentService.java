package com.application.paymentservice.service;

import com.application.paymentservice.model.dto.PaymentDTO;
import com.application.paymentservice.model.request.PaymentRequest;
import com.application.paymentservice.model.response.PaymentResponse;

public interface PaymentService {
    PaymentDTO doPayment(PaymentRequest request);

    PaymentResponse getPaymentDetailsByOrderId(Long orderId);
}
