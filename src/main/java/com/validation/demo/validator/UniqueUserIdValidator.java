package com.validation.demo.validator;

import java.util.Arrays;
import java.util.List;

import com.validation.demo.annotation.UniqueUserId;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUserIdValidator implements ConstraintValidator<UniqueUserId, Long>{
	
	// Simulating a database of existing user IDs
    private final List<Long> existingUserIds = Arrays.asList(1L, 2L, 3L);
    
    @Override
    public boolean isValid(Long userId, ConstraintValidatorContext context) {
        // If ID is null, let other validations handle it
        if (userId == null) {
            return true;
        }
        return !existingUserIds.contains(userId);
    }

}
