package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.UserDTO;
import com.skypedal.skypedal_backend.dto.UserDTO;
import com.skypedal.skypedal_backend.entities.User;
import com.skypedal.skypedal_backend.entities.User;
import com.skypedal.skypedal_backend.exceptions.UserNotFoundException;
import com.skypedal.skypedal_backend.exceptions.UnauthenticatedUserException;
import com.skypedal.skypedal_backend.exceptions.UserNotFoundException;
import com.skypedal.skypedal_backend.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public UserDTO add(UserDTO userDTO) {
        User user = this.repo.save(new User(userDTO));
        return new UserDTO(user);
    }

    public List<UserDTO> get() {
        List<User> users = this.repo.findAll();
        return users.stream().map(UserDTO::new).toList();
    }

    public UserDTO getById(Integer userId) {
        User user = this.repo.findById(userId).orElseThrow(UserNotFoundException::new);
        return new UserDTO(user);
    }

    public UserDTO removeById(Integer userId) {
        User user = this.repo.findById(userId).orElseThrow(UserNotFoundException::new);
        this.repo.deleteById(userId);
        return new UserDTO(user);

    }

    public UserDTO updateById(Integer userId, UserDTO newUser) {
        User user = this.repo.findById(userId).orElseThrow(UserNotFoundException::new);
        newUser.setId(user.getId());
        User savedUser = this.repo.save(new User(newUser));
        return new UserDTO(savedUser);
    }
}
