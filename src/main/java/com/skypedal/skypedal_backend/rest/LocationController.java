package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.dto.LocationDTO;
import com.skypedal.skypedal_backend.services.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public LocationDTO add(@RequestBody LocationDTO locationDTO, @RequestParam Integer userId) {
        return this.service.add(locationDTO, userId);
    }

    @GetMapping("")
    public List<LocationDTO> getAll(@RequestParam Integer userId) {
        return this.service.get(userId);
    }

    @GetMapping("/{id}")
    public LocationDTO get(@PathVariable Integer id, @RequestParam Integer userId) {
        return this.service.getById(id, userId);
    }

    @DeleteMapping("/{id}")
    public LocationDTO delete(@PathVariable Integer id, @RequestParam Integer userId) {
        return this.service.removeById(id, userId);
    }
}
