package repo;

import entities.UsersRewards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRewardsRepo extends JpaRepository<UsersRewards, Integer> {
}
