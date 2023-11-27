package com.application.productservice.exception;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ErrorResponse {
    private String errorMessage;
    private String errorCode;
}
