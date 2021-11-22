package com.solilori.nullpaper.services;

import com.solilori.nullpaper.dto.PrinterDto;
import com.solilori.nullpaper.entities.Printer;
import com.solilori.nullpaper.repositories.PrinterRepository;
import com.solilori.nullpaper.services.exceptions.DatabaseException;
import com.solilori.nullpaper.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrinterService {

    @Autowired
    private PrinterRepository printerRepository;

    @Transactional(readOnly = true)
    public List<PrinterDto> findAll() {
        List<Printer> list = printerRepository.findAll();
        return list.stream().map(x -> new PrinterDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PrinterDto findById(Long id) {
        Optional<Printer> opt = printerRepository.findById(id);
        Printer entity = opt.orElseThrow(() -> new ResourceNotFoundException("Printer not found!"));
        return new PrinterDto(entity);
    }

    @Transactional
    public PrinterDto insert(PrinterDto dto) {
        Printer entity = new Printer();
        copyDtoToEntity(dto, entity);
        entity = printerRepository.save(entity);
        return new PrinterDto(entity);

    }

    @Transactional
    public PrinterDto update(Long id, PrinterDto dto) {
        try {
            Printer entity = printerRepository.getById(id);
            copyDtoToEntity(dto, entity);
            entity.setId(id);
            entity = printerRepository.save(entity);
            return new PrinterDto(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Printer ID not found: " + id);
        }
    }

    @Transactional
    public void delete(Long id) {
        try {
            printerRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Printer ID not found: " + id);

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity DB violation");
        }
    }


    private void copyDtoToEntity(PrinterDto dto, Printer entity) {
        entity.setId(dto.getId());
        entity.setManufacturer(dto.getManufacturer());
        entity.setModel(dto.getModel());
        entity.setSerialNumber(dto.getSerialNumber());
        entity.setActive(dto.isActive());
    }
}
