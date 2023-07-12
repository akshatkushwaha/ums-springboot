package com.akshat.project.university.management.system.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        HttpStatus httpStatus = e.getHttpStatus();
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus
        );
        return new ResponseEntity<>(apiException, httpStatus);
    }
}
