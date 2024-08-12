package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.LocationDTO;
import com.skypedal.skypedal_backend.entities.Location;
import com.skypedal.skypedal_backend.entities.User;
import com.skypedal.skypedal_backend.exceptions.LocationNotFoundException;
import com.skypedal.skypedal_backend.exceptions.UnauthenticatedUserException;
import com.skypedal.skypedal_backend.exceptions.UserNotFoundException;
import com.skypedal.skypedal_backend.repo.LocationRepo;
import com.skypedal.skypedal_backend.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepo repo;
    private final UserRepo userRepo;

    private final MapsAPIService mapsAPIService;

    public LocationService(LocationRepo repo, UserRepo userRepo, MapsAPIService mapsAPIService) {
        this.repo = repo;
        this.userRepo = userRepo;
        this.mapsAPIService = mapsAPIService;
    }

    public LocationDTO add(LocationDTO locationDTO, Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        Location location = this.repo.save(new Location(locationDTO, user));
        return new LocationDTO(location);
    }

    public List<LocationDTO> query(String query, Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        return this.mapsAPIService.fetchLocations(query).block();

    }

    public List<LocationDTO> get(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        List<Location> route = this.repo.findAll();
        return route.stream().map(LocationDTO::new).toList();
    }

    public LocationDTO getById(Integer routeId, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        Location route = this.repo.findById(routeId).orElseThrow(LocationNotFoundException::new);
        if (route.getUser() != user) throw new UnauthenticatedUserException(); //TODO: Or is admin
        return new LocationDTO(route);
    }

    public LocationDTO removeById(Integer routeId, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        Location route = this.repo.findById(routeId).orElseThrow(LocationNotFoundException::new);
        if (route.getUser() != user) throw new UnauthenticatedUserException(); //TODO: Or is admin
        this.repo.deleteById(routeId);
        return new LocationDTO(route);

    }
}
