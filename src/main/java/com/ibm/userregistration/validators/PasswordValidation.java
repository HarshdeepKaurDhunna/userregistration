/**
 * 
 */
package com.ibm.userregistration.validators;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 
 */
public class PasswordValidation implements ConstraintValidator<PasswordValidator, String> {
	  @Override
	  public boolean isValid(String value, ConstraintValidatorContext context) {
		  
	    // check if string contains at least 1 number, 1 Capitalized letter, 1 special character in this set “_#$%"
	    return value.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[_#$%]).{8,}$");
	  }
	}


