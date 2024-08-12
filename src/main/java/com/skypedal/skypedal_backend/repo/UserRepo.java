package com.skypedal.skypedal_backend.repo;

import com.skypedal.skypedal_backend.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<MyUser, Integer> {
    Optional<MyUser> findByUsername(String userName);
}
