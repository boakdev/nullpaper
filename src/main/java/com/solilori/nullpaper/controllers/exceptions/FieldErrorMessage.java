package com.solilori.nullpaper.controllers.exceptions;

import java.io.Serializable;

public class FieldErrorMessage implements Serializable {

    private String fieldName;
    private String message;

    public FieldErrorMessage() {

    }

    public FieldErrorMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
