package com.springboot.management_event.validation;

import com.springboot.management_event.model.entities.Account;
import com.springboot.management_event.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {
       Account account = accountRepository.findByUsername(userName).get();


        return account==null ? true : false;
    }
}
