package com.application.orderservice.model.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProductDetails {
    private String productName;
    private Long productId;
    private Long quantity;
    private Long price;
}
