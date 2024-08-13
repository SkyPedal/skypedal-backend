package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.dto.NewUsersRewardsDTO;
import com.skypedal.skypedal_backend.dto.UsersRewardsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.skypedal.skypedal_backend.services.UsersRewardsService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users_rewards")
public class UsersRewardsController {

    private UsersRewardsService service;

    public UsersRewardsController(UsersRewardsService service) {
        this.service = service;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public UsersRewardsDTO createUserReward(@RequestBody NewUsersRewardsDTO newUserReward) {
        return this.service.createReward(newUserReward);
    }

    @GetMapping("/{id}")
    public UsersRewardsDTO getUserReward(@PathVariable int id) {
        return this.service.getUserReward(id);
    }

    @GetMapping("/user/{userId}")
    public List<UsersRewardsDTO> getUserRewardsByUserId(@PathVariable int userId) {
        List<UsersRewardsDTO> usersRewardsDTOList = this.service.getUserRewardsByUserId(userId);
        List<UsersRewardsDTO> toReturn = new ArrayList<>();
        for (UsersRewardsDTO ur : usersRewardsDTOList) {
            if (!ur.isHasUsed()) {
                toReturn.add(ur);
            }
        }

        return toReturn;
    }
}
