package gym.macros.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gym.macros.entity.Diet;
import gym.macros.entity.DietFood;

public interface DietFoodRepository extends JpaRepository<DietFood, Integer>{
	
//	List<DietFood> findByDietId(Integer dietId);
}
