package com.skypedal.skypedal_backend.repo;

import com.skypedal.skypedal_backend.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepo extends JpaRepository<Route, Integer> {
}
