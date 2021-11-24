package com.solilori.nullpaper.services;

import com.solilori.nullpaper.dto.CustomerDto;
import com.solilori.nullpaper.dto.PrinterDto;
import com.solilori.nullpaper.entities.Customer;
import com.solilori.nullpaper.entities.Printer;
import com.solilori.nullpaper.repositories.CustomerRepository;
import com.solilori.nullpaper.repositories.PrinterRepository;
import com.solilori.nullpaper.services.exceptions.DatabaseException;
import com.solilori.nullpaper.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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

    @Transactional
    public CustomerDto insert(CustomerDto dto) {
        Customer entity = new Customer();
        copyDtoToEntity(dto, entity);
        entity = customerRepository.save(entity);
        return new CustomerDto(entity);
    }

    @Transactional
    public CustomerDto update(Long id, CustomerDto dto) {
        try {
            Customer entity = customerRepository.getById(id);
            copyDtoToEntity(dto, entity);
            entity = customerRepository.save(entity);
            return new CustomerDto(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Customer not found: " + id);
        }
    }

    @Transactional
    public void delete(Long id) {
        try {
            customerRepository.deleteById(id);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Customer not found: " + id);

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity DB violation");
        }
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
