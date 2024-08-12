package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.UsersRewardsDTO;
import com.skypedal.skypedal_backend.entities.UsersRewards;
import com.skypedal.skypedal_backend.exceptions.UsersRewardsNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.skypedal.skypedal_backend.repo.UsersRewardsRepo;

@Service
@Primary
public class UsersRewardsService {

    private UsersRewardsRepo repo;

    public UsersRewardsService(UsersRewardsRepo repo) {
        this.repo = repo;
    }

    public UsersRewardsDTO createReward(UsersRewardsDTO newUserReward) {
        UsersRewards toSave = new UsersRewards(newUserReward);
        this.repo.save(toSave);
        return new UsersRewardsDTO(toSave);
    }

    public UsersRewardsDTO getUserReward(int id) {
        UsersRewards found = this.repo.findById(id).orElseThrow(UsersRewardsNotFoundException::new);
        return new UsersRewardsDTO(found);
    }
}
