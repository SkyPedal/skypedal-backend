package com.skypedal.skypedal_backend.repo;

import com.skypedal.skypedal_backend.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepo extends JpaRepository<Location, Integer> {
    List<Location> findAllByUserId(Long userId);
}
