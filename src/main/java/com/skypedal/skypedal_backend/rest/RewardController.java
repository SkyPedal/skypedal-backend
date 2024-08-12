package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.dto.RewardDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.skypedal.skypedal_backend.services.RewardService;

import java.util.List;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    private RewardService service;

    public RewardController(RewardService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public RewardDTO createReward(@RequestBody RewardDTO newReward) {
        return this.service.createReward(newReward);
    }

    @GetMapping("/{id}")
    public RewardDTO getReward(@PathVariable int id) {
        return this.service.getReward(id);
    }

    @GetMapping("/getAll")
    public List<RewardDTO> getRewards() {
        return this.service.getRewards();
    }

    @GetMapping("/getActive")
    public List<RewardDTO> getAvailableRewards() {
        return this.service.getAvailableRewards();
    }

    @PatchMapping("/update/{id}")
    public RewardDTO updateReward(@PathVariable int id,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) String description,
                                  @RequestParam(required = false) Integer pointCost,
                                  @RequestParam(required = false) Integer numberAvailable,
                                  @RequestParam(required = false) String imageLink,
                                  @RequestParam(required = false) Boolean active) {

        return this.service.updateReward(id, name, description, pointCost, numberAvailable, imageLink, active);
    }
}
