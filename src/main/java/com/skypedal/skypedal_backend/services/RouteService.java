package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.LocationDTO;
import com.skypedal.skypedal_backend.dto.NewRouteDTO;
import com.skypedal.skypedal_backend.dto.RouteDTO;
import com.skypedal.skypedal_backend.entities.Location;
import com.skypedal.skypedal_backend.entities.Route;
import com.skypedal.skypedal_backend.entities.User;
import com.skypedal.skypedal_backend.exceptions.LocationNotFoundException;
import com.skypedal.skypedal_backend.exceptions.UserNotFoundException;
import com.skypedal.skypedal_backend.repo.LocationRepo;
import com.skypedal.skypedal_backend.repo.RouteRepo;
import com.skypedal.skypedal_backend.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    private final RouteRepo repo;
    private final LocationRepo locationRepo;
    private final UserRepo userRepo;

    public RouteService(RouteRepo repo, LocationRepo locationRepo, UserRepo userRepo) {
        this.repo = repo;
        this.locationRepo = locationRepo;
        this.userRepo = userRepo;
    }

    public RouteDTO add(NewRouteDTO newRoute, Integer userId) {
        // Call the maps API
        User user = this.userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        Location startLocation = this.locationRepo.findById(newRoute.getStartId()).orElseThrow(LocationNotFoundException::new);
        Location endLocation =
                this.locationRepo.findById(newRoute.getEndId()).orElseThrow(LocationNotFoundException::new);
        String geoJson = null;
        Integer distanceM = null;
        Integer durationS = null;
        Route route = this.repo.save(new Route(startLocation, endLocation, user, geoJson, distanceM, durationS));
        return new RouteDTO(route);
    }
}
