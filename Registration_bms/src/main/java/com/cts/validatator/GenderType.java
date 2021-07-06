package com.cts.validatator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GenderTypeValidatator.class)
public @interface GenderType {
	String message() default "Gender must be Male , Female or Others";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
