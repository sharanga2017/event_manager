package com.springboot.management_event.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { MyEmailValidator.class })
public @interface MyEmail {

    String message() default "Doit être unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}