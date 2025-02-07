package com.validation.demo.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.validation.demo.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	// Handle ValidationException and return the list of validation errors
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<List<ErrorResponse>> handleValidationException(ValidationException ex) {
        // Return the list of errors in the response body, with a 400 Bad Request status
        return new ResponseEntity<>(ex.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
