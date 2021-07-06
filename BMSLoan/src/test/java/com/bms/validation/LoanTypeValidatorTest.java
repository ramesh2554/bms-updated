package com.bms.validation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import javax.validation.ConstraintValidatorContext;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoanTypeValidatorTest {

	@Mock
	LoanType loanType;
	
	
	@Mock
	ConstraintValidatorContext constraintValidatorContext;
	
   
	
	@Test
	void testIsValid() {
		 when(loanType.message()).thenReturn("Loan Type must be Education , Personal or Home");
		 LoanTypeValidator loanTypeValidator = new LoanTypeValidator();
		 loanTypeValidator.initialize(loanType);
		 boolean result = loanTypeValidator.isValid("Personal", constraintValidatorContext);
		 assertTrue(result);
	}

	 
}
