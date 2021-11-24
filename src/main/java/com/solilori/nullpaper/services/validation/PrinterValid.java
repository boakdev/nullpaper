package com.solilori.nullpaper.services.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PrinterValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrinterValid {

    String message() default "Printer validation error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
