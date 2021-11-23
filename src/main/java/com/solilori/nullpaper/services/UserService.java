package com.solilori.nullpaper.services;

import com.solilori.nullpaper.dto.RoleDto;
import com.solilori.nullpaper.dto.UserDto;
import com.solilori.nullpaper.dto.UserInsertDto;
import com.solilori.nullpaper.entities.Role;
import com.solilori.nullpaper.entities.User;
import com.solilori.nullpaper.repositories.RoleRepository;
import com.solilori.nullpaper.repositories.UserRepository;
import com.solilori.nullpaper.services.exceptions.DatabaseException;
import com.solilori.nullpaper.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        List<User> list = userRepository.findAll();
        return list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDto findById(Long id) {
        Optional<User> opt = userRepository.findById(id);
        User entity = opt.orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
        return new UserDto(entity);
    }

    @Transactional
    public UserDto insert(UserInsertDto dto) {
        User entity = new User();
        copyDtoToEntity(dto, entity);
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity = userRepository.save(entity);
        return new UserDto(entity);

    }

    @Transactional
    public UserDto update(Long id, UserDto dto) {
        try {
            User entity = userRepository.getById(id);
            copyDtoToEntity(dto, entity);
            entity = userRepository.save(entity);
            return new UserDto(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("User not found: " + id);
        }
    }


    public void delete(Long id) {
        try {
            userRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("User not found: " + id);

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity DB violation");
        }
    }


    private void copyDtoToEntity(UserDto dto, User entity) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());

        entity.getRoles().clear();

        for (RoleDto roleDto : dto.getRoles()) {
            Role role = roleRepository.getById(roleDto.getId());
            entity.getRoles().add(role);
        }
    }
}
