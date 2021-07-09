package com.springboot.management_event.validation;

import com.springboot.management_event.repositories.AccountRepository;
import com.springboot.management_event.repositories.EventRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueNameEvent, String> {

    private final EventRepository events;

    public UniqueNameValidator(EventRepository events) {
        this.events = events;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return !events.existsByName(value);
    }
}
