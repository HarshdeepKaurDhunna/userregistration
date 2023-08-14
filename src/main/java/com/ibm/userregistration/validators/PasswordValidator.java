package com.ibm.userregistration.validators;


import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = PasswordValidation.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PasswordValidator {
  String message() default "Must be 8 characters long and combination of uppercase letters, lowercase letters, numbers, special characters.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
