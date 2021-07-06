package com.bms.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class LoanTypeValidator implements ConstraintValidator<LoanType, String>{

	public final List<String >loanType = Arrays.asList("Education" , "Personal" , "Home" , "home" ,"education" ,"personal");
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return loanType.contains(value);
	}
}