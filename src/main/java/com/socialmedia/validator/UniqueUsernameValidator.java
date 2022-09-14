package com.socialmedia.validator;

import com.socialmedia.annotation.UniqueUsername;
import com.socialmedia.model.User;
import com.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        User inDB = userRepository.findByUsername(username);
        return inDB == null;
    }
}
