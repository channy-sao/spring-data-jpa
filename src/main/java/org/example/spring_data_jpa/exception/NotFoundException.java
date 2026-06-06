package org.example.spring_data_jpa.exception;

public class NotFoundException extends AppException {
    public NotFoundException(String message) {
        super("NOT_FOUND", message);
    }
}
