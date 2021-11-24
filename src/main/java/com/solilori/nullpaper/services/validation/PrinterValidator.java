package com.solilori.nullpaper.services.validation;

import com.solilori.nullpaper.controllers.exceptions.FieldErrorMessage;
import com.solilori.nullpaper.dto.PrinterDto;
import com.solilori.nullpaper.entities.Printer;
import com.solilori.nullpaper.repositories.PrinterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class PrinterValidator implements ConstraintValidator<PrinterValid, PrinterDto> {

    @Autowired
    private PrinterRepository printerRepository;

    @Override
    public void initialize(PrinterValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(PrinterDto dto, ConstraintValidatorContext context) {

        List<FieldErrorMessage> listError = new ArrayList<>();

        Printer printer = printerRepository.findBySerialNumber(dto.getSerialNumber());
        if (printer != null) {
            listError.add(new FieldErrorMessage("serialNumber", "Serial já cadastrado"));
        }

        for (FieldErrorMessage f : listError) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(f.getMessage()).addPropertyNode(f.getFieldName()).addConstraintViolation();
        }

        return listError.isEmpty();
    }
}
