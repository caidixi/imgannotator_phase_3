package wnderful.imgannotator.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.imgannotator.dao.entity.Reward;

public interface RewardRepository extends JpaRepository<Reward,Long> {
    Reward findRewardByTaskNameAndWorkerUsername(String name,String username);

    Reward[] findRewardByWorkerUsername(String username);
}
