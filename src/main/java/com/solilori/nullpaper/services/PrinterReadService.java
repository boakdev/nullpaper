package com.solilori.nullpaper.services;

import com.solilori.nullpaper.dto.PrinterReadDto;
import com.solilori.nullpaper.entities.PrinterRead;
import com.solilori.nullpaper.repositories.PrinterReadRepository;
import com.solilori.nullpaper.services.exceptions.DatabaseException;
import com.solilori.nullpaper.services.exceptions.ResourceExistOnDayException;
import com.solilori.nullpaper.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
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

    @Transactional(readOnly = true)
    public List<PrinterReadDto> findBySerialPrinter(String serie) {
        List<PrinterRead> list = printerReadRepository.findBySerialNumber(serie);
        return list.stream().map(x -> new PrinterReadDto(x)).collect(Collectors.toList());
    }


    @Transactional
    public PrinterReadDto insert(PrinterReadDto dto) {
        PrinterRead entity = new PrinterRead();
        copyDtoToEntity(dto, entity);

        boolean persist = true;

        ZoneId zone = ZoneId.of("America/Sao_Paulo");
        Optional<LocalDate> dateOpt = Optional.of(LocalDate.ofInstant(entity.getDate(), zone));
        LocalDate dateReadEntity = dateOpt.get();
        System.out.println("Data da entidade POST: " + dateReadEntity);

        List<PrinterRead> listPrinterRead = printerReadRepository.findBySerialNumber(entity.getSerialNumber());
        System.out.println("Lista de Leituras: " + listPrinterRead);

        if (listPrinterRead.isEmpty()) {
            System.out.println("Entrou no IF da lista vazia - PERSISTIU");
            entity = printerReadRepository.save(entity);
            return new PrinterReadDto(entity);
        }

        if (listPrinterRead.size() > 0) {

            for (PrinterRead p : listPrinterRead) {

                Optional<LocalDate> dateReadListOpt = Optional.of(LocalDate.ofInstant(p.getDate(), zone));
                LocalDate dateReadList = dateReadListOpt.get();
                System.out.println("Data do obj lista: " + dateReadList);

                if (dateReadEntity.equals(dateReadList)) {
                    System.out.println("Entrou no IF de data igual - valor persist FALSE");
                    persist = false;
                }
            }
        }

        if (persist) {
            System.out.println("entrou no IF de PERSIST");
            entity = printerReadRepository.save(entity);
            return new PrinterReadDto(entity);

        } else {
            throw new ResourceExistOnDayException("printer has already been registered today - Serial: " + entity.getSerialNumber());
        }
    }

    public void delete(Long id) {

        try {
            printerReadRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("PrinterRead ID not found " + id);

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
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
