package com.skypedal.skypedal_backend.Services;

import com.skypedal.skypedal_backend.dto.UserDTO;
import com.skypedal.skypedal_backend.entities.User;
import com.skypedal.skypedal_backend.repo.UserRepo;
import org.springframework.stereotype.Service;
import com.skypedal.skypedal_backend.Exceptions.UserNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

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

    public UserDTO getUser(int id) {
        User found = this.repo.findById(id).orElseThrow(UserNotFoundException::new);
        return new UserDTO(found);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = this.repo.findAll();
        return this.repo.findAll().stream().map(UserDTO::new).toList();
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(user);
    }
}
