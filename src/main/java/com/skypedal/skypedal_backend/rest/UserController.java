package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.Services.UserService;
import com.skypedal.skypedal_backend.dto.UserDTO;
import com.skypedal.skypedal_backend.entities.User;
import com.skypedal.skypedal_backend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDTO create(@RequestBody UserDTO user) {
        return this.service.add(user);
    }


    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody @Validated UserDTO user) {
        return this.service.registerUser(user);
    }


    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable int id) {
        return this.service.getUser(id);
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return this.service.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(
            @PathVariable int id,
            @RequestBody UserDTO userDTO) {
        return this.service.updateUser(id, userDTO);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        this.service.deleteUser(id);
    }
}
