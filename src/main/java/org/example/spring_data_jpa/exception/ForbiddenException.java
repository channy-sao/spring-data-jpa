package org.example.spring_data_jpa.exception;

public class ForbiddenException extends AppException {
    public ForbiddenException(String message) {
        super("FORBIDDEN", message);
    }
}
