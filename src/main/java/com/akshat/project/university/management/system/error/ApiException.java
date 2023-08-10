package com.akshat.project.university.management.system.error;

import org.springframework.http.HttpStatus;

public record ApiException(String message, HttpStatus httpStatus) {
    public ApiException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
