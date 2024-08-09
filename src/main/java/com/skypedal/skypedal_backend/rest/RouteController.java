package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.dto.NewRouteDTO;
import com.skypedal.skypedal_backend.dto.RouteDTO;
import com.skypedal.skypedal_backend.services.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/routes")
public class RouteController {
    private final RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public RouteDTO create(@RequestBody NewRouteDTO route, @RequestParam Integer userId) {
        return this.service.add(route, userId);
    }
}
