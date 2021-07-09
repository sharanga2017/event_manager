package com.springboot.management_event.validation;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { UniqueEmailValidator.class })
public @interface UniqueEmail {

    String message() default "Already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}