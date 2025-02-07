package com.validation.demo.exception;

import java.util.List;

import com.validation.demo.dto.ErrorResponse;

public class ValidationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7570076225300939888L;
	
	private List<ErrorResponse> errors;

	public ValidationException(String message, List<ErrorResponse> errors) {
        super(message);
        this.errors = errors;
    }

    public List<ErrorResponse> getErrors() {
        return errors;
    }

}
