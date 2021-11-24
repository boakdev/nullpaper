package com.solilori.nullpaper.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldErrorMessage> errors = new ArrayList<>();

    public List<FieldErrorMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldErrorMessage(fieldName, message));
    }
}
