package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.UserDTO;
import com.skypedal.skypedal_backend.entities.User;
import com.skypedal.skypedal_backend.exceptions.UserNotFoundException;
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

    public List<UserDTO> getAll() {
        return this.repo.findAll().stream().map(UserDTO::new).toList();
    }

    public UserDTO registerUser(UserDTO user) {
        User newUser = new User(user);
        newUser.setPassword_Hash(this.passwordEncoder.encode(user.getPassword()));
        this.repo.save(newUser);
        return user;
    }

    public List<UserDTO> get() {
        List<User> users = this.repo.findAll();
        return users.stream().map(UserDTO::new).toList();
    }

    public UserDTO getById(Long userId) {
        User user = this.repo.findById(userId).orElseThrow(UserNotFoundException::new);
        return new UserDTO(user);
    }

    public UserDTO removeById(Long userId) {
        User user = this.repo.findById(userId).orElseThrow(UserNotFoundException::new);
        this.repo.deleteById(userId);
        return new UserDTO(user);

    }

    public UserDTO updateById(Long userId, UserDTO newUser) {
        User user = this.repo.findById(userId).orElseThrow(UserNotFoundException::new);
        user.setRewardPoints(newUser.getRewardPoints());
        User savedUser = this.repo.save(user);
        return new UserDTO(savedUser);
    }
}
