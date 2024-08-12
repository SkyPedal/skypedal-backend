package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.UserDTO;
import com.skypedal.skypedal_backend.entities.User;
import com.skypedal.skypedal_backend.repo.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo repo;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO add(UserDTO userDTO) {
        User user = this.repo.save(new User(userDTO));
        return new UserDTO(user);
    }

    public List<UserDTO> getAll() {
        return this.repo.findAll().stream().map(UserDTO::new).toList();
    }

    public UserDTO registerUser(UserDTO user) {
        User newUser = new User(user);
        newUser.setPasswordHash(this.passwordEncoder.encode(user.getPassword()));
        this.repo.save(newUser);
        return user;
    }
}
