package org.example.spring_data_jpa.exception;

public class UnauthorizedException extends AppException {
    public UnauthorizedException(String message) {
        super("UNAUTHORIZED", message);
    }
}
