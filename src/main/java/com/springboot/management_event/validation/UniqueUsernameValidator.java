package com.springboot.management_event.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.springboot.management_event.repositories.AccountRepository;

public class UniqueUsernameValidator
        implements ConstraintValidator<UniqueUsername, String> {

    private final AccountRepository accounts;

    public UniqueUsernameValidator(AccountRepository accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return !accounts.existsByUsername(value);
    }
}
