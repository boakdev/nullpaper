package com.solilori.nullpaper.services;

import com.solilori.nullpaper.dto.CustomerDto;
import com.solilori.nullpaper.dto.PrinterDto;
import com.solilori.nullpaper.entities.Customer;
import com.solilori.nullpaper.entities.Printer;
import com.solilori.nullpaper.repositories.CustomerRepository;
import com.solilori.nullpaper.repositories.PrinterRepository;
import com.solilori.nullpaper.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PrinterRepository printerRepository;

    @Transactional(readOnly = true)
    public List<CustomerDto> findAll() {
        List<Customer> list = customerRepository.findAll();
        return list.stream().map(x -> new CustomerDto(x, x.getPrinters())).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CustomerDto findById(Long id) {
        Optional<Customer> opt = customerRepository.findById(id);
        Customer entity = opt.orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + id));
        return new CustomerDto(entity, entity.getPrinters());
    }


    private void copyDtoToEntity(CustomerDto dto, Customer entity) {

        entity.setName(dto.getName());
        entity.setCpfCnpj(dto.getCpfCnpj());
        entity.setEmail(dto.getEmail());
        entity.setCompany(dto.getCompany());
        entity.setCellPhone(dto.getCellPhone());
        entity.setPhone(dto.getPhone());
        entity.setStreetAddress(dto.getStreetAddress());
        entity.setZipCodeAddress(dto.getZipCodeAddress());
        entity.setNumberAddress(dto.getNumberAddress());
        entity.setComplementAddress(dto.getComplementAddress());
        entity.setDistrictAddress(dto.getDistrictAddress());
        entity.setCityAddress(dto.getCityAddress());
        entity.setStateAddress(dto.getStateAddress());
        entity.setCountryAddress(dto.getCountryAddress());
        entity.setComments(dto.getComments());

        entity.getPrinters().clear();
        for (PrinterDto pdto : dto.getPrinters()) {
            Printer printer = printerRepository.getById(pdto.getId());
            entity.getPrinters().add(printer);
        }

    }
}
