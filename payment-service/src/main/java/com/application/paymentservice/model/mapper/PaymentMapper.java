package com.application.paymentservice.model.mapper;

import com.application.paymentservice.entity.TransactionDetails;
import com.application.paymentservice.model.dto.PaymentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDTO mapToPaymentDTO(TransactionDetails transactionDetails);
}
