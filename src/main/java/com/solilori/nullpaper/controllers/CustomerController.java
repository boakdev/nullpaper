package com.solilori.nullpaper.controllers;

import com.solilori.nullpaper.dto.CustomerDto;
import com.solilori.nullpaper.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Tag(name = "Customer API", description = "Manage customer data")
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    @Operation(description = "Find all customers")
    public ResponseEntity<List<CustomerDto>> get() {
        List<CustomerDto> list = customerService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    @Operation(description = "Find a specific customer by id")
    public ResponseEntity<CustomerDto> getById(@PathVariable("id") Long id) {
        CustomerDto dto = customerService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @Operation(description = "Add a customer")
    public ResponseEntity<CustomerDto> insert(@Valid @RequestBody CustomerDto dto) {
        dto = customerService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    @Operation(description = "Update a customer")
    public ResponseEntity<CustomerDto> update(@PathVariable Long id, @Valid @RequestBody CustomerDto dto) {
        dto = customerService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(description = "Delete a customer")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
