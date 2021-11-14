package com.solilori.nullpaper.controllers;

import com.solilori.nullpaper.dto.PrinterReadDto;
import com.solilori.nullpaper.services.PrinterReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/readings")
public class PrinterReadController {

    @Autowired
    PrinterReadService printerReadService;


    @GetMapping
    public ResponseEntity<List<PrinterReadDto>> findAll() {
        List<PrinterReadDto> listDto = printerReadService.findAll();
        return ResponseEntity.ok().body(listDto);

    }

    @PostMapping
    public ResponseEntity<PrinterReadDto> insert(@RequestBody PrinterReadDto dto) {
        dto = printerReadService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
