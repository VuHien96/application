package com.application.orderservice.entity;

import com.application.orderservice.enumm.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "order_date")
    private Instant orderDate;
    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;
    @Column(name = "amount")
    private Long amount;
}
