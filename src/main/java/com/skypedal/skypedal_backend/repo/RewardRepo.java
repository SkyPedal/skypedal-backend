package com.skypedal.skypedal_backend.repo;

import com.skypedal.skypedal_backend.entities.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RewardRepo extends JpaRepository<Reward, Integer> {
}
