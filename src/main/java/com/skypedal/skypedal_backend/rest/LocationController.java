package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.dto.LocationDTO;
import com.skypedal.skypedal_backend.entities.MyUserDetails;
import com.skypedal.skypedal_backend.services.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public LocationDTO add(@RequestBody LocationDTO locationDTO, @AuthenticationPrincipal MyUserDetails userDetail) {
        return this.service.add(locationDTO, userDetail.id);
    }

    @GetMapping("/search")
    public List<LocationDTO> query(@RequestParam String query,  @AuthenticationPrincipal MyUserDetails userDetails) {
        return this.service.query(query, userDetails.id);
    }


    @GetMapping("")
    public List<LocationDTO> getAll( @AuthenticationPrincipal MyUserDetails userDetails) {
        return this.service.get(userDetails.id);
    }

    @GetMapping("/{id}")
    public LocationDTO get(@PathVariable Integer id,  @AuthenticationPrincipal MyUserDetails userDetails) {
        return this.service.getById(id, userDetails.id);
    }

    @DeleteMapping("/{id}")
    public LocationDTO delete(@PathVariable Integer id,  @AuthenticationPrincipal MyUserDetails userDetails) {
        return this.service.removeById(id, userDetails.id);
    }
}
