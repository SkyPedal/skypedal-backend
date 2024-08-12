package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.LocationDTO;
import com.skypedal.skypedal_backend.entities.Location;
import com.skypedal.skypedal_backend.entities.MyUser;
import com.skypedal.skypedal_backend.exceptions.UserNotFoundException;
import com.skypedal.skypedal_backend.repo.LocationRepo;
import com.skypedal.skypedal_backend.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    private final LocationRepo repo;
    private final UserRepo userRepo;

    public LocationService(LocationRepo repo, UserRepo userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public LocationDTO add(LocationDTO locationDTO, Integer userId) {
        MyUser myUser = userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        Location location = this.repo.save(new Location(locationDTO, myUser));
        return new LocationDTO(location);
    }
}
