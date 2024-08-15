package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.dto.NewRouteDTO;
import com.skypedal.skypedal_backend.dto.RouteDTO;
import com.skypedal.skypedal_backend.entities.MyUserDetails;
import com.skypedal.skypedal_backend.services.RouteService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {
    private final RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public RouteDTO create(@RequestBody NewRouteDTO route, @AuthenticationPrincipal MyUserDetails userDetails) {
        return this.service.add(route, userDetails.id);
    }

    @GetMapping("")
    public List<RouteDTO> getAll(@AuthenticationPrincipal MyUserDetails userDetails) {
        return this.service.get(userDetails.id);
    }

    @GetMapping("/{id}")
    public RouteDTO get(@PathVariable Integer id, @AuthenticationPrincipal MyUserDetails userDetails) {
        return this.service.getById(id, userDetails.id);
    }

    @GetMapping("/start/{startId}/end/{endId}")
    public RouteDTO getByEnds(@PathVariable Integer startId, @PathVariable Integer endId,
                              @AuthenticationPrincipal MyUserDetails userDetails) {
        return this.service.getByEnds(startId, endId, userDetails.id);
    }

    @DeleteMapping("/{id}")
    public RouteDTO delete(@PathVariable Integer id, @AuthenticationPrincipal MyUserDetails userDetails) {
        return this.service.removeById(id, userDetails.id);
    }
}
