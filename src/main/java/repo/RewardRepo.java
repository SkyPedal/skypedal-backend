package repo;

import entities.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RewardRepo extends JpaRepository<Reward, Integer> {
}
