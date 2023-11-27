package com.application.paymentservice.entity;

import com.application.paymentservice.enumm.PaymentEnum;
import com.application.paymentservice.enumm.PaymentStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "transaction_details")
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "payment_model")
    @Enumerated(EnumType.STRING)
    private PaymentEnum paymentModel;
    @Column(name = "reference_number")
    private String referenceNumber;
    @Column(name = "payment_date")
    private Instant paymentDate;
    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatus;
    @Column(name = "amount")
    private Long amount;
}
