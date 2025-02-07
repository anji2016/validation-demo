package com.validation.demo.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.validation.demo.validator.UniqueUserIdValidator;

import java.lang.annotation.ElementType;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = UniqueUserIdValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUserId {
	String message() default "User ID already exists.";  // Default error message

    Class<?>[] groups() default {};  // Validation groups

    Class<? extends Payload>[] payload() default {};  // Payload type
}
