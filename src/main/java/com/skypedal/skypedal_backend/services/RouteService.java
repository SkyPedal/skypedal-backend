package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.LocationDTO;
import com.skypedal.skypedal_backend.dto.NewRouteDTO;
import com.skypedal.skypedal_backend.dto.RouteDTO;
import com.skypedal.skypedal_backend.entities.Location;
import com.skypedal.skypedal_backend.entities.Route;
import com.skypedal.skypedal_backend.entities.User;
import com.skypedal.skypedal_backend.exceptions.*;
import com.skypedal.skypedal_backend.repo.LocationRepo;
import com.skypedal.skypedal_backend.repo.RouteRepo;
import com.skypedal.skypedal_backend.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

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

        Route createdRoute = this.repo.save(new Route(newRoute, startLocation, endLocation, user));
        return new RouteDTO(createdRoute);
    }

    public List<RouteDTO> get(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        List<Route> routes = this.repo.findByUserId(userId);
        return routes.stream().map(RouteDTO::new).toList();
    }

    public RouteDTO getById(Integer routeId, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        Route route = this.repo.findById(routeId).orElseThrow(RouteNotFoundException::new);
        if (route.getUser() != user) throw new UnauthenticatedUserException(); //TODO: Or is admin
        return new RouteDTO(route);
    }

    public RouteDTO removeById(Integer routeId, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        Route route = this.repo.findById(routeId).orElseThrow(RouteNotFoundException::new);
        if (route.getUser() != user) throw new UnauthenticatedUserException(); //TODO: Or is admin
        this.repo.deleteById(routeId);
        return new RouteDTO(route);

    }
}
