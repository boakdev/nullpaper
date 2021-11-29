package com.solilori.nullpaper.controllers;

import com.solilori.nullpaper.dto.PrinterDto;
import com.solilori.nullpaper.services.PrinterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@Tag(name = "Printer API", description = "Manage printer data")
@RequestMapping(value = "/printers")
public class PrinterController {

    @Autowired
    private PrinterService printerService;

    @GetMapping
    @Operation(description = "Find all printers")
    public ResponseEntity<List<PrinterDto>> get() {
        List<PrinterDto> listDto = printerService.findAll();
        listDto.forEach(dto -> dto.add(linkTo(methodOn(PrinterController.class).getById(dto.getId())).withSelfRel()));
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    @Operation(description = "Find a specific printer by id")
    public ResponseEntity<PrinterDto> getById(@PathVariable("id") Long id) {
        PrinterDto dto = printerService.findById(id);
        dto.add(linkTo(methodOn(PrinterController.class).get()).withRel("List all printers"));
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @Operation(description = "Add a printer")
    public ResponseEntity<PrinterDto> insert(@Valid @RequestBody PrinterDto dto) {
        dto = printerService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    @Operation(description = "Update a printer")
    public ResponseEntity<PrinterDto> update(@PathVariable("id") Long id, @Valid @RequestBody PrinterDto dto) {
        dto = printerService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(description = "Delete a printer")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        printerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
