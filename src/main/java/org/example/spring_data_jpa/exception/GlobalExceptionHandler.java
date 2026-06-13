package org.example.spring_data_jpa.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.spring_data_jpa.dto.response.BaseBodyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<BaseBodyResponse<Void>> handleAppException(
            AppException ex, HttpServletRequest request) {

        log.warn("AppException {}: {}", ex.getErrorCode(), ex.getMessage());

        return BaseBodyResponse.failed(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseBodyResponse<Void>> handleNotFoundException(NotFoundException ex, HttpServletRequest request) {
        log.warn("NotFoundException {}: {}", ex.getErrorCode(), ex.getMessage());
        return BaseBodyResponse.failed(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BaseBodyResponse<Void>> handleBadRequestException(BadRequestException ex, HttpServletRequest request) {
        log.warn("BadRequestException {}: {}", ex.getErrorCode(), ex.getMessage());
        return BaseBodyResponse.failed(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

}
