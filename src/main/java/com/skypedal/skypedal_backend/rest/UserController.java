package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.Services.UserService;
import com.skypedal.skypedal_backend.dto.UserDTO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

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

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable int id) {
        return this.service.getUser(id);
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return this.service.getAllUsers();
    }

}
