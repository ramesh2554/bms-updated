package com.bms.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoanTypeValidator.class)
public @interface LoanType {
	String message() default "Loan Type must be Education , Personal or Home";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
