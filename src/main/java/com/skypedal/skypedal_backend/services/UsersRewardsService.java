package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.NewUsersRewardsDTO;
import com.skypedal.skypedal_backend.dto.RewardDTO;
import com.skypedal.skypedal_backend.dto.UserDTO;
import com.skypedal.skypedal_backend.dto.UsersRewardsDTO;
import com.skypedal.skypedal_backend.entities.UsersRewards;
import com.skypedal.skypedal_backend.exceptions.RewardNotAvailableException;
import com.skypedal.skypedal_backend.exceptions.UserIsTooPoorException;
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
    private UserService userService;

    public UsersRewardsService(UsersRewardsRepo repo, RewardService rewardService, UserService userService) {
        this.repo = repo;
        this.rewardService = rewardService;
        this.userService = userService;
    }

    public UsersRewardsDTO createReward(NewUsersRewardsDTO newUserReward) {
        UsersRewards toSave = new UsersRewards(newUserReward);

        /* there is now one less available reward remaining */
        rewardService.redeemReward(toSave.getReward().getId());

        /* user pays for the reward if they have enough points */
        Integer rewardCost = rewardService.getReward(toSave.getReward().getId()).getPointCost();
        Integer userPoints = userService.getById(toSave.getUser().getId()).getRewardPoints();
        Integer remainingPoints = userPoints - rewardCost;

        if (remainingPoints < 0) throw new UserIsTooPoorException();
        else {
            UserDTO newUser = userService.getById(toSave.getUser().getId());
            newUser.setRewardPoints(remainingPoints);
            userService.updateById(newUser.getId(), newUser);
            this.repo.save(toSave);

            return new UsersRewardsDTO(toSave);
        }
    }

    public UsersRewardsDTO getUserReward(int id) {
        UsersRewards found = this.repo.findById(id).orElseThrow(UsersRewardsNotFoundException::new);
        return new UsersRewardsDTO(found);
    }

    public List<UsersRewardsDTO> getUserRewardsByUserId(long userId) {
        return this.repo.findAllByUserId(userId).stream().map(UsersRewardsDTO::new).toList();
    }

    public UsersRewardsDTO useUserReward(int id) {
        UsersRewards found = this.repo.findById(id).orElseThrow(UsersRewardsNotFoundException::new);
        found.setHasUsed(true);
        this.repo.save(found);
        return new UsersRewardsDTO(found);
    }
}
