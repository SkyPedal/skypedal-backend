package com.skypedal.skypedal_backend.repo;

import com.skypedal.skypedal_backend.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location, Integer> {
}
