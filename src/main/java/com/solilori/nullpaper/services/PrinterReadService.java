package com.solilori.nullpaper.services;

import com.solilori.nullpaper.dto.PrinterReadDto;
import com.solilori.nullpaper.entities.PrinterRead;
import com.solilori.nullpaper.repositories.PrinterReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrinterReadService {

    @Autowired
    private PrinterReadRepository printerReadRepository;


    @Transactional(readOnly = true)
    public List<PrinterReadDto> findAll() {
        List<PrinterRead> list = printerReadRepository.findAll();
        return list.stream().map(x -> new PrinterReadDto(x)).collect(Collectors.toList());
    }


    @Transactional
    public PrinterReadDto insert(PrinterReadDto dto) {
        PrinterRead entity = new PrinterRead();
        copyDtoToEntity(dto, entity);
        entity = printerReadRepository.save(entity);
        return new PrinterReadDto(entity);
    }


    private void copyDtoToEntity(PrinterReadDto dto, PrinterRead entity) {
        entity.setManufacturer(dto.getManufacturer());
        entity.setModel(dto.getModel());
        entity.setSerialNumber(dto.getSerialNumber());
        entity.setIpAddress(dto.getIpAddress());
        entity.setTonerRemaining(dto.getTonerRemaining());
        entity.setTonerCapacity(dto.getTonerCapacity());
        entity.setTotalPages(dto.getTotalPages());
        entity.setDate(dto.getDate());
        entity.setComputer(dto.getComputer());
    }


}
