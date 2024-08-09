package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.dto.LocationDTO;
import com.skypedal.skypedal_backend.services.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public LocationDTO add(@RequestBody LocationDTO locationDTO, @RequestParam(required = true) String name, Integer userId) {
        return this.service.add(locationDTO, userId);
    }
}
