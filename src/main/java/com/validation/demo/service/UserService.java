package com.validation.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.validation.demo.dto.ErrorResponse;
import com.validation.demo.dto.UserDTO;

import jakarta.validation.Valid;

@Service
public class UserService{
	
	private final List<String> existingPhoneNumbers = Arrays.asList("123456789678", "45678912564321", "987654321908"); // Simulating DB

    public String registerUser(@Valid UserDTO user) {
        return "User registered successfully: " + user.getName();
    }

	public List<ErrorResponse> validate(Object object) {
		List<ErrorResponse> errors = new ArrayList<>();
		UserDTO userRequest = (UserDTO) object;

        // Validation 1: Check if phone number already exists
        if (existingPhoneNumbers.contains(userRequest.getPhoneNumber())) {
            errors.add(new ErrorResponse("phoneNumber", "Phone number is already registered"));
        }

        // Validation 2: Check if age is below 18
        if (userRequest.getAge() < 18) {
            errors.add(new ErrorResponse("age", "User must be at least 18 years old"));
        }

        return errors; // Return all service-level validation errors
	}
}
