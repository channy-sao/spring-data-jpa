package org.example.spring_data_jpa.exception;

public class DuplicateException extends AppException {
    public DuplicateException(String message) {
        super("DUPLICATE", message);
    }
}
