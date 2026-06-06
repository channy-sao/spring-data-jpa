package org.example.spring_data_jpa.exception;

public class BadRequestException extends AppException {
    public BadRequestException(String message) {
        super("BAD_REQUEST", message);
    }
}
