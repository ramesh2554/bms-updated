package com.bms.validatator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bms.model.RegistrationDetails;

public class AccountTypeValidator implements ConstraintValidator<AccountType, String>{
	RegistrationDetails details= new RegistrationDetails();

	public final List<String >accountType = Arrays.asList("Savings" , "Salary" , "savings" , "salary");
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		
		return accountType.contains(value);
	}

}
