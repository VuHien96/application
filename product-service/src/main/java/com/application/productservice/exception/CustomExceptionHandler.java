//package com.application.productservice.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//
//import java.util.ArrayList;
//
//@RestControllerAdvice
//public class CustomExceptionHandler {
//
//    @ExceptionHandler(InternalException.class)
//    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
//        var details = new ArrayList<String>();
//        details.add(ex.getLocalizedMessage());
//        var error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), details);
//        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(NotFoundException.class)
//    public final ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) {
//        var details = new ArrayList<String>();
//        details.add(ex.getLocalizedMessage());
//        var error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), details);
//        return ResponseEntity.ok(error);
//    }
//
//    @ExceptionHandler(BadRequestException.class)
//    public final ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request) {
//        var details = new ArrayList<String>();
//        details.add(ex.getLocalizedMessage());
//        var error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), details);
//        return ResponseEntity.ok(error);
//    }
//}
