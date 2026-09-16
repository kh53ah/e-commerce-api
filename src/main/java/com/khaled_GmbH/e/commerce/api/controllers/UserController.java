package com.khaled_GmbH.e.commerce.api.controllers;

import com.khaled_GmbH.e.commerce.api.dtos.RegisterUserRequest;
import com.khaled_GmbH.e.commerce.api.dtos.UserDto;
import com.khaled_GmbH.e.commerce.api.mappers.UserMapper;
import com.khaled_GmbH.e.commerce.api.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    public Iterable<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }
    @GetMapping("/{id}")
    public ResponseEntity <UserDto> getUser(@PathVariable UUID id) {
        var user = userRepository.findById(id).orElse(null);
        if (user== null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(userMapper.toDto(user));
    }
    @PostMapping
    public ResponseEntity <?> registerUser(
            @Valid @RequestBody RegisterUserRequest request,
            UriComponentsBuilder uriBuilder) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body(
                    Map.of("email", "Email is already registered")
            );
        }

        var user = userMapper.toEntity(request);
        userRepository.save(user);

        var userDto = userMapper.toDto(user);

        var uri = uriBuilder.path("/users/{id}").buildAndExpand(userDto.getId()).toUri();

        return ResponseEntity.created(uri).body(userDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity <UserDto> updateUser(
            @PathVariable(name = "id") UUID id,
            @RequestBody UpdateUserRequest request){
        var user = userRepository.findById(id).orElse(null);
        if (user == null)
            return ResponseEntity.notFound().build();
        userMapper.update(request, user);
        userRepository.save(user);

        return ResponseEntity.ok(userMapper.toDto(user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <UserDto> deleteUser(
            @PathVariable(name = "id") UUID id){
        var user = userRepository.findById(id).orElse(null);
        if (user == null)
            return ResponseEntity.notFound().build();

        userRepository.delete(user);

        return ResponseEntity.noContent().build();
    }
}
