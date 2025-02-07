package com.validation.demo.service;

import java.util.List;

import com.validation.demo.dto.ErrorResponse;

public interface ValidationStrategy {
    List<ErrorResponse> validate(Object object);
}
