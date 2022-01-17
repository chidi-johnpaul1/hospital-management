package com.calpha.hospital.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.calpha.hospital.dto.UserDto;

public class PasswordMatcherValidator implements ConstraintValidator<PasswordMatcher, Object> {

    @Override
    public void initialize(final PasswordMatcher constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final UserDto user = (UserDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }

}
