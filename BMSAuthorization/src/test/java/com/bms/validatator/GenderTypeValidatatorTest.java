package com.bms.validatator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.validation.ConstraintValidatorContext;

import org.junit.jupiter.api.Test;

class GenderTypeValidatatorTest {

	private GenderType genderType = mock(GenderType.class);

	private ConstraintValidatorContext constraintValidatorContext = mock(ConstraintValidatorContext.class);

	@Test
	void testIsValid() {
		when(genderType.message()).thenReturn("Gender must be Male , Female or Others");
		GenderTypeValidatator genderTypeValidatator = new GenderTypeValidatator();
		genderTypeValidatator.initialize(genderType);
		boolean result = genderTypeValidatator.isValid("Male", constraintValidatorContext);
		assertTrue(result);
	}

}
