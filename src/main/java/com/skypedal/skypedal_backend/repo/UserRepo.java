package com.skypedal.skypedal_backend.repo;

import com.skypedal.skypedal_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}