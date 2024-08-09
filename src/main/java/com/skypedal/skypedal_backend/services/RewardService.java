package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.RewardDTO;
import com.skypedal.skypedal_backend.entities.Reward;
import com.skypedal.skypedal_backend.exceptions.RewardNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.skypedal.skypedal_backend.repo.RewardRepo;

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
}
