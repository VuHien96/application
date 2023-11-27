package com.application.orderservice.external.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProductResponse {
    private String productName;
    private Long productId;
    private Long quantity;
    private Long price;
}
