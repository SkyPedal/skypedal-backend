package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.dto.UserDTO;
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
    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody @Validated UserDTO user) {
        return this.service.registerUser(user);
    }


    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable long id) {
        return this.service.getById(id);
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return this.service.getAll();
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(
            @PathVariable long id,
            @RequestBody UserDTO userDTO) {
        return this.service.updateById(id, userDTO);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id) {
        this.service.removeById(id);
    }
}
