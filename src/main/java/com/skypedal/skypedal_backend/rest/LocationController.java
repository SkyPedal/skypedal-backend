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
    public LocationDTO add(@RequestBody LocationDTO locationDTO, @RequestParam Long userId) {
        return this.service.add(locationDTO, userId);
    }

    @GetMapping("/search")
    public List<LocationDTO> query(@RequestParam String query, @RequestParam Long userId) {
        return this.service.query(query, userId);
    }


    @GetMapping("")
    public List<LocationDTO> getAll(@RequestParam Long userId) {
        return this.service.get(userId);
    }

    @GetMapping("/{id}")
    public LocationDTO get(@PathVariable Integer id, @RequestParam Long userId) {
        return this.service.getById(id, userId);
    }

    @DeleteMapping("/{id}")
    public LocationDTO delete(@PathVariable Integer id, @RequestParam Long userId) {
        return this.service.removeById(id, userId);
    }
}
