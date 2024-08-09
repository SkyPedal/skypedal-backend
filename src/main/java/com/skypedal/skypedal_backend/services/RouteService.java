package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.LocationDTO;
import com.skypedal.skypedal_backend.dto.NewRouteDTO;
import com.skypedal.skypedal_backend.dto.RouteDTO;
import com.skypedal.skypedal_backend.entities.Location;
import com.skypedal.skypedal_backend.entities.Route;
import com.skypedal.skypedal_backend.entities.User;
import com.skypedal.skypedal_backend.exceptions.LocationNotFoundException;
import com.skypedal.skypedal_backend.exceptions.NoRouteFoundException;
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
    private final MapsAPIService mapsAPIService;

    public RouteService(RouteRepo repo, LocationRepo locationRepo, UserRepo userRepo, MapsAPIService mapsAPIService) {
        this.repo = repo;
        this.locationRepo = locationRepo;
        this.userRepo = userRepo;
        this.mapsAPIService = mapsAPIService;
    }

    public RouteDTO add(NewRouteDTO route, Integer userId) {
        // Call the maps API
        User user = this.userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        Location startLocation = this.locationRepo.findById(route.getStartId()).orElseThrow(LocationNotFoundException::new);
        Location endLocation =
                this.locationRepo.findById(route.getEndId()).orElseThrow(LocationNotFoundException::new);
        RouteDTO newRoute = this.mapsAPIService.fetchRoute(new LocationDTO(startLocation), new LocationDTO(endLocation)).block();
        if (newRoute == null) throw new NoRouteFoundException();
        String geoJson = null;
        Integer distanceM = null;
        Integer durationS = null;
        Route createdRoute = this.repo.save(new Route(newRoute, startLocation, endLocation, user));
        return new RouteDTO(createdRoute);
    }
}
