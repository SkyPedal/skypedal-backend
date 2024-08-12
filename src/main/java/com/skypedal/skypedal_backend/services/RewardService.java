package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.RewardDTO;
import com.skypedal.skypedal_backend.entities.Reward;
import com.skypedal.skypedal_backend.exceptions.RewardNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.skypedal.skypedal_backend.repo.RewardRepo;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class RewardService {

    private RewardRepo repo;

    public RewardService(RewardRepo repo) {
        this.repo = repo;
    }

    public RewardDTO createReward(RewardDTO newReward) {
        Reward toSave = new Reward(newReward);
        this.repo.save(toSave);
        return new RewardDTO(toSave);
    }

    public RewardDTO getReward(int id) {
        Reward found = this.repo.findById(id).orElseThrow(RewardNotFoundException::new);
        return new RewardDTO(found);
    }

    public List<RewardDTO> getRewards() {
        return this.repo.findAll().stream().map(RewardDTO::new).toList();
    }

    public List<RewardDTO> getAvailableRewards() {
        List<RewardDTO> rewardDTOList = this.repo.findAll().stream().map(RewardDTO::new).toList();
        List<RewardDTO> toReturn = new ArrayList<>();
        for (RewardDTO r : rewardDTOList) {
            if (r.isActive() && r.getNumberAvailable() > 0) toReturn.add(r);
        }
        return toReturn;
    }

    public RewardDTO updateReward(Integer id, String name, String description, Integer pointCost, Integer numberAvailable, String imageLink, Boolean active) {
        Reward found = this.repo.findById(id).orElseThrow(RewardNotFoundException::new);

        if (name != null) found.setName(name);
        if (description != null) found.setDescription(description);
        if (pointCost != null) found.setPointCost(pointCost);
        if (numberAvailable != null) found.setNumberAvailable(numberAvailable);
        if (imageLink != null) found.setImageLink(imageLink);
        if (active != null) found.setActive(active);

        Reward updated = this.repo.save(found);
        return new RewardDTO(updated);
    }
}
