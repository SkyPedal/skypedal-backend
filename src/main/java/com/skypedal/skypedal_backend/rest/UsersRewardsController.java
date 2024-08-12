package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.dto.UsersRewardsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.skypedal.skypedal_backend.services.UsersRewardsService;

import java.util.List;

@RestController
@RequestMapping("/users_rewards")
public class UsersRewardsController {

    private UsersRewardsService service;

    public UsersRewardsController(UsersRewardsService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UsersRewardsDTO createUserReward(@RequestBody UsersRewardsDTO newUserReward) {
        return this.service.createReward(newUserReward);
    }

    @GetMapping("/{id}")
    public UsersRewardsDTO getUserReward(@PathVariable int id) {
        return this.service.getUserReward(id);
    }

    @GetMapping("/get/{userId}")
    public List<UsersRewardsDTO> getUserRewardsByUserId(@PathVariable int userId) {
        return this.service.getUserRewardsByUserId(userId);
    }
}
