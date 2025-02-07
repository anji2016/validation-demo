package com.validation.demo.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.validation.demo.dto.UserDTO;
import com.validation.demo.service.UserService;
import com.validation.demo.service.ValidationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
    private final ValidationService validationService;

    public UserController(UserService userService, ValidationService validationService) {
        this.userService = userService;
        this.validationService = validationService;
    }
	
	@PostMapping("/register")
    public String registerUser(@Valid @RequestBody UserDTO dto, BindingResult bindingResult) {
        
        // Validate using the validation service
        validationService.validateRequest(bindingResult, userService.validate(dto));
        
        return "User Registered Successfully";
    }
	
	
	
	

}
