package com.solilori.nullpaper.services.validation;

import com.solilori.nullpaper.controllers.exceptions.FieldErrorMessage;
import com.solilori.nullpaper.dto.UserInsertDto;
import com.solilori.nullpaper.dto.UserUpdateDto;
import com.solilori.nullpaper.entities.User;
import com.solilori.nullpaper.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDto> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public void initialize(UserUpdateValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserUpdateDto dto, ConstraintValidatorContext context) {

        var uriVars = (Map<String, String>) httpServletRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        long userId = Long.parseLong(uriVars.get("id"));

        List<FieldErrorMessage> listError = new ArrayList<>();

        User user = userRepository.findByEmail(dto.getEmail());
        if (user != null && userId != user.getId()) {
            listError.add(new FieldErrorMessage("email", "Email já cadastrado"));
        }

        for (FieldErrorMessage f : listError) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(f.getMessage()).addPropertyNode(f.getFieldName()).addConstraintViolation();
        }

        return listError.isEmpty();
    }
}
