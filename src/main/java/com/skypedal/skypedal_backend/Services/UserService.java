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
        return this.repo.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO updateUser(int id, UserDTO userDTO) {
        User existingUser = this.repo.findById(id).orElseThrow(UserNotFoundException::new);

        // Only update fields that are not null in the UserDTO
        if (userDTO.getFirstName() != null) {
            existingUser.setFirstName(userDTO.getFirstName());
        }
        if (userDTO.getLastName() != null) {
            existingUser.setLastName(userDTO.getLastName());
        }
        if (userDTO.getEmail() != null) {
            existingUser.setEmail(userDTO.getEmail());
        }
        if (userDTO.getOfficeLocation() != null) {
            existingUser.setOfficeLocation(userDTO.getOfficeLocation());
        }
        if (0 != userDTO.getRewardPoints()) {
            existingUser.setRewardPoints(userDTO.getRewardPoints());
        }

        // Save updated user back to the database
        User updatedUser = this.repo.save(existingUser);
        return new UserDTO(updatedUser);
    }

    public void deleteUser(int id) {
        User existingUser = this.repo.findById(id).orElseThrow(UserNotFoundException::new);
        this.repo.delete(existingUser);
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(user);
    }
}
