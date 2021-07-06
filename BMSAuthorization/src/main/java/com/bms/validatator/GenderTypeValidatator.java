package com.bms.validatator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class GenderTypeValidatator implements ConstraintValidator<GenderType, String>  {
	private final List<String>  genderType = Arrays.asList("Male", "Female" , "Others","male", "female" , "others");
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return genderType.contains(value);
	}

}
