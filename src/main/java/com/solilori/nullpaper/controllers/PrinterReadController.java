package com.solilori.nullpaper.controllers;

import com.solilori.nullpaper.dto.PrinterReadDto;
import com.solilori.nullpaper.services.PrinterReadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Tag(name = "Printer Read API", description = "Manage printer read data")
@RequestMapping(value = "/readings")
public class PrinterReadController {

    @Autowired
    PrinterReadService printerReadService;


    @GetMapping
    @Operation(description = "Find all printer reads")
    public ResponseEntity<List<PrinterReadDto>> get() {
        List<PrinterReadDto> listDto = printerReadService.findAll();
        return ResponseEntity.ok().body(listDto);

    }

    @GetMapping("/{serial}")
    @Operation(description = "Find a specific printer read by serial number")
    public ResponseEntity<List<PrinterReadDto>> getBySerialPrinter(@PathVariable String serial) {
        List<PrinterReadDto> listDto = printerReadService.findBySerialPrinter(serial);
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    @Operation(description = "Add a printer read")
    public ResponseEntity<PrinterReadDto> insert(@RequestBody PrinterReadDto dto) {
        dto = printerReadService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(description = "Delete a printer read")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        printerReadService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
