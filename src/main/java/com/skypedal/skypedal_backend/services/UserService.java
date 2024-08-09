package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.UserDTO;
import com.skypedal.skypedal_backend.entities.User;
import com.skypedal.skypedal_backend.repo.UserRepo;
import org.springframework.stereotype.Service;

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
}
