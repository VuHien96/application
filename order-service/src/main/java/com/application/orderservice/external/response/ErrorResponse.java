package com.application.orderservice.external.response;

import lombok.*;

import java.util.List;

//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//@Builder
//public class ErrorResponse {
//    private int code;
//    private String message;
//    private List<String> details;
//}


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private String errorMessage;
    private String errorCode;
}