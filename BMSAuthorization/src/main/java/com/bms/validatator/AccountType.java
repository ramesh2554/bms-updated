package com.bms.validatator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AccountTypeValidator.class)
public @interface AccountType {
	String message() default "AccountType must be Savings or Salary";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
