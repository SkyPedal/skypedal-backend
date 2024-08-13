package com.skypedal.skypedal_backend.repo;

import com.skypedal.skypedal_backend.entities.UsersRewards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRewardsRepo extends JpaRepository<UsersRewards, Integer> {

    List<UsersRewards> findAllByUserId (Long userId);
}
