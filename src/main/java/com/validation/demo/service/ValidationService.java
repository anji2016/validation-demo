package com.validation.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.validation.demo.dto.ErrorResponse;
import com.validation.demo.exception.ValidationException;

@Service
public class ValidationService {

    // Method to validate user input (both field and service-level)
    public List<ErrorResponse> validateRequest(BindingResult bindingResult, List<ErrorResponse> serviceErrors) {
        List<ErrorResponse> errorResponses = new ArrayList<>();

        // Step 1: Collect field-level validation errors
        for (FieldError error : bindingResult.getFieldErrors()) {
            errorResponses.add(new ErrorResponse(error.getField(), error.getDefaultMessage()));
        }

     // Step 2: Collect service-layer validation errors using the strategy
        errorResponses.addAll(serviceErrors);

        // Step 3: If errors exist, throw ValidationException
        if (!errorResponses.isEmpty()) {
            throw new ValidationException("Validation failed", errorResponses);
        }

        return errorResponses;
    }

}
