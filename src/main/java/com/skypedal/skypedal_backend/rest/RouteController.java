package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.dto.NewRouteDTO;
import com.skypedal.skypedal_backend.dto.RouteDTO;
import com.skypedal.skypedal_backend.services.RouteService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.HttpStatus;
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
    public RouteDTO create(@RequestBody NewRouteDTO route, @RequestParam Integer userId) {
        return this.service.add(route, userId);
    }

    @GetMapping("")
    public List<RouteDTO> getAll(@RequestParam Integer userId) {
        return this.service.get(userId);
    }

    @GetMapping("/{id}")
    public RouteDTO get(@PathVariable Integer id, @RequestParam Integer userId) {
        return this.service.getById(id, userId);
    }

    @GetMapping("/start/{startId}/end/{endId}")
    public RouteDTO getByEnds(@PathVariable Integer startId, @PathVariable Integer endId,
                              @RequestParam Integer userId) {
        return this.service.getByEnds(startId, endId, userId);
    }

    @DeleteMapping("/{id}")
    public RouteDTO delete(@PathVariable Integer id, @RequestParam Integer userId) {
        return this.service.removeById(id, userId);
    }
}
