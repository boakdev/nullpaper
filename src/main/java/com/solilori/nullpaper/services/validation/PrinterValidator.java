package com.solilori.nullpaper.services.validation;

import com.solilori.nullpaper.controllers.exceptions.FieldErrorMessage;
import com.solilori.nullpaper.dto.PrinterDto;
import com.solilori.nullpaper.entities.Printer;
import com.solilori.nullpaper.repositories.PrinterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PrinterValidator implements ConstraintValidator<PrinterValid, PrinterDto> {

    @Autowired
    private PrinterRepository printerRepository;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public void initialize(PrinterValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(PrinterDto dto, ConstraintValidatorContext context) {

        var uriVars = (Map<String, String>) httpServletRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Optional<String> opt = Optional.ofNullable(uriVars.get("id"));
        long printerId;

        if(!opt.isEmpty()){
            printerId = Long.parseLong(opt.get());
        } else{
            printerId = -1;
        }

        List<FieldErrorMessage> listError = new ArrayList<>();

        Printer printer = printerRepository.findBySerialNumber(dto.getSerialNumber());


            if (printer != null && printerId != printer.getId()) {
                listError.add(new FieldErrorMessage("serialNumber", "Serial já cadastrado"));
            }




        for (FieldErrorMessage f : listError) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(f.getMessage()).addPropertyNode(f.getFieldName()).addConstraintViolation();
        }

        return listError.isEmpty();
    }
}
