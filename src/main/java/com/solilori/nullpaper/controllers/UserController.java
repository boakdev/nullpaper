package com.solilori.nullpaper.controllers;

import com.solilori.nullpaper.dto.UserDto;
import com.solilori.nullpaper.dto.UserInsertDto;
import com.solilori.nullpaper.dto.UserUpdateDto;
import com.solilori.nullpaper.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> get() {
        List<UserDto> listDto = userService.findAll();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") Long id) {
        UserDto dto = userService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<UserDto> insert(@Valid @RequestBody UserInsertDto dto) {
        UserDto newDto = userService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDto> update(@PathVariable("id") Long id, @Valid @RequestBody UserUpdateDto dto) {
        UserDto newDto = userService.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
