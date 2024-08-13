package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.dto.UserDTO;
import com.skypedal.skypedal_backend.entities.User;
import com.skypedal.skypedal_backend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public UserDTO create(@RequestBody UserDTO user) {
        return this.service.add(user);
    }

    @GetMapping("/getAll")
    public List<UserDTO> getAll() {
        return this.service.getAll();
    }

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody @Validated UserDTO user) {
        return this.service.registerUser(user);
    }

    @GetMapping("")
    public List<UserDTO> getAll(@RequestParam Long userId) {
        return this.service.get();
    }

    @GetMapping("/{id}")
    public UserDTO get(@PathVariable Long id) {
        return this.service.getById(id);
    }

    @DeleteMapping("/{id}")
    public UserDTO delete(@PathVariable Long id) {
        return this.service.removeById(id);
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO user) {
        return this.service.updateById(id, user);
    }

}
