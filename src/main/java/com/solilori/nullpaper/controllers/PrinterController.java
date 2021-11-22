package com.solilori.nullpaper.controllers;

import com.solilori.nullpaper.dto.PrinterDto;
import com.solilori.nullpaper.services.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/printers")
public class PrinterController {

    @Autowired
    private PrinterService printerService;

    @GetMapping
    public ResponseEntity<List<PrinterDto>> get() {
        List<PrinterDto> listDto = printerService.findAll();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PrinterDto> getById(@PathVariable("id") Long id) {
        PrinterDto dto = printerService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<PrinterDto> insert(@RequestBody PrinterDto dto) {
        dto = printerService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PrinterDto> update(@PathVariable("id") Long id, @RequestBody PrinterDto dto) {
        dto = printerService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PrinterDto> delete(@PathVariable Long id) {
        printerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
