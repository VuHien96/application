package com.application.paymentservice.service.impl;

import com.application.paymentservice.entity.TransactionDetails;
import com.application.paymentservice.enumm.PaymentStatusEnum;
import com.application.paymentservice.model.dto.PaymentDTO;
import com.application.paymentservice.model.mapper.PaymentMapper;
import com.application.paymentservice.model.request.PaymentRequest;
import com.application.paymentservice.model.response.PaymentResponse;
import com.application.paymentservice.repository.PaymentRepository;
import com.application.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public PaymentDTO doPayment(PaymentRequest request) {
        log.info("Start doPayment with param [{}]", request.toString());
        TransactionDetails details = TransactionDetails.builder()
                .paymentDate(Instant.now())
                .paymentModel(request.getPaymentModel())
                .paymentStatus(PaymentStatusEnum.SUCCESS)
                .orderId(request.getOrderId())
                .referenceNumber(request.getReferenceNumber())
                .amount(request.getAmount())
                .build();
        paymentRepository.save(details);
        log.info("Transaction completed with id [{}]", details.getId());
        return paymentMapper.mapToPaymentDTO(details);
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(Long orderId) {
        log.info("Getting payment details for the Order Id: {}", orderId);

        var transactionDetails
                = paymentRepository.findByOrderId(orderId);

        return PaymentResponse.builder()
                .paymentId(transactionDetails.getId())
                .paymentMode(transactionDetails.getPaymentModel())
                .paymentDate(transactionDetails.getPaymentDate())
                .orderId(transactionDetails.getOrderId())
                .status(transactionDetails.getPaymentStatus())
                .amount(transactionDetails.getAmount())
                .build();
    }
}
