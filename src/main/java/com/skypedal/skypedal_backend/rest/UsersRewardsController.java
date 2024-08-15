package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.dto.NewUsersRewardsDTO;
import com.skypedal.skypedal_backend.dto.UsersRewardsDTO;
import com.skypedal.skypedal_backend.entities.MyUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @PostMapping("/redeem/{rewardId}")
    @ResponseStatus(HttpStatus.CREATED)
    public UsersRewardsDTO createUserReward(@PathVariable Integer rewardId, @AuthenticationPrincipal MyUserDetails userDetail) {
        NewUsersRewardsDTO newUserReward = new NewUsersRewardsDTO(rewardId, userDetail.id);
        return this.service.createReward(newUserReward);
    }

    @GetMapping("/{id}")
    public UsersRewardsDTO getUserReward(@PathVariable int id) {
        return this.service.getUserReward(id);
    }

    @GetMapping("/user")
    public List<UsersRewardsDTO> getUserRewardsByUserId(@AuthenticationPrincipal MyUserDetails userDetail) {
        List<UsersRewardsDTO> usersRewardsDTOList = this.service.getUserRewardsByUserId(userDetail.id);
        List<UsersRewardsDTO> toReturn = new ArrayList<>();
        for (UsersRewardsDTO ur : usersRewardsDTOList) {
            if (!ur.isHasUsed()) {
                toReturn.add(ur);
            }
        }

        return toReturn;
    }

    @PatchMapping("/{id}")
    public UsersRewardsDTO useUserReward(@PathVariable int id) {
        return this.service.useUserReward(id);
    }
}
