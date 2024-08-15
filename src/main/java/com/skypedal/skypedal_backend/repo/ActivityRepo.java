package com.skypedal.skypedal_backend.repo;

import com.skypedal.skypedal_backend.dto.ActivityDTO;
import com.skypedal.skypedal_backend.entities.Activity;
import com.skypedal.skypedal_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActivityRepo extends JpaRepository<Activity, Integer> {
    List<Activity> findByUser(User user);
}
