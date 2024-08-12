package com.skypedal.skypedal_backend.repo;

import com.skypedal.skypedal_backend.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepo extends JpaRepository<Route, Integer> {
    List<Route> findByUserId(Integer userId);
}
