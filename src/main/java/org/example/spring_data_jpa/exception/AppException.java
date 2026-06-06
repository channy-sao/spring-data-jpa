package org.example.spring_data_jpa.exception;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
    private final String errorCode;
    public AppException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
