package com.cts.validatator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.validation.ConstraintValidatorContext;

import org.junit.jupiter.api.Test;

class AccountTypeValidatorTest {

	private AccountType accountType = mock(AccountType.class);

	private ConstraintValidatorContext constraintValidatorContext = mock(ConstraintValidatorContext.class);

	@Test
	void testIsValid() {
		when(accountType.message()).thenReturn("AccountType must be Savings or Salary");
		AccountTypeValidator loanTypeValidator = new AccountTypeValidator();
		loanTypeValidator.initialize(accountType);
		boolean result = loanTypeValidator.isValid("Savings", constraintValidatorContext);
		assertTrue(result);
	}

}
