package com.application.orderservice.exception;

import lombok.Data;

import java.util.List;

@Data
public class CustomException extends RuntimeException {

    private String errorCode;
    private int status;

    public CustomException(String message, String errorCode, int status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

//    private int code;
//    private String message;
//    private List<String> details;
//
//    public CustomException(int code, String message, List<String> details) {
//        this.code = code;
//        this.message = message;
//        this.details = details;
//    }
}
