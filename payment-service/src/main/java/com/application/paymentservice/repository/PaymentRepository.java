package com.application.paymentservice.repository;

import com.application.paymentservice.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<TransactionDetails, Long> {

    TransactionDetails findByOrderId(long orderId);
}
