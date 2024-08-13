package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.RewardDTO;
import com.skypedal.skypedal_backend.dto.UsersRewardsDTO;
import com.skypedal.skypedal_backend.entities.UsersRewards;
import com.skypedal.skypedal_backend.exceptions.UsersRewardsNotFoundException;
import com.skypedal.skypedal_backend.rest.RewardController;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.skypedal.skypedal_backend.repo.UsersRewardsRepo;

import java.util.List;

@Service
@Primary
public class UsersRewardsService {

    private UsersRewardsRepo repo;
    private RewardService rewardService;

    public UsersRewardsService(UsersRewardsRepo repo, RewardService rewardService) {
        this.repo = repo;
        this.rewardService = rewardService;
    }

    public UsersRewardsDTO createReward(UsersRewardsDTO newUserReward) {
        UsersRewards toSave = new UsersRewards(newUserReward);
        this.repo.save(toSave);

        /* there is now one less available reward remaining */
        System.out.println("saved successfully: " + toSave + "; with id: " + toSave.getReward().getId());
        Integer numbAvail = rewardService.getReward(toSave.getReward().getId()).getNumberAvailable();
        System.out.println("numb available: " + numbAvail);




        /* THIS LINE DOES NOT UPDATE THE REWARD, WHY???? */
        rewardService.updateReward(toSave.getReward().getId(), null, null, null, numbAvail - 1, null, numbAvail > 1);

        return new UsersRewardsDTO(toSave);
    }

    public UsersRewardsDTO getUserReward(int id) {
        UsersRewards found = this.repo.findById(id).orElseThrow(UsersRewardsNotFoundException::new);
        return new UsersRewardsDTO(found);
    }

    public List<UsersRewardsDTO> getUserRewardsByUserId(int userId) {
        return this.repo.findAllByUserId(userId).stream().map(UsersRewardsDTO::new).toList();
    }
}
