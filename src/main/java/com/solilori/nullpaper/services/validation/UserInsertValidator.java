package com.solilori.nullpaper.services.validation;

import com.solilori.nullpaper.controllers.exceptions.FieldErrorMessage;
import com.solilori.nullpaper.dto.UserInsertDto;
import com.solilori.nullpaper.entities.User;
import com.solilori.nullpaper.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDto> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UserInsertValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserInsertDto dto, ConstraintValidatorContext context) {

        List<FieldErrorMessage> listError = new ArrayList<>();

        User user = userRepository.findByEmail(dto.getEmail());
        if (user != null) {
            listError.add(new FieldErrorMessage("email", "Email já cadastrado"));
        }

        for (FieldErrorMessage f : listError) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(f.getMessage()).addPropertyNode(f.getFieldName()).addConstraintViolation();
        }

        return listError.isEmpty();
    }
}
