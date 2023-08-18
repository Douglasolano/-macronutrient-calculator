package gym.macros.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gym.macros.entity.PortionedFoodPortionedDiet;

public interface PortionedFoodPortionedDietRepository extends JpaRepository<PortionedFoodPortionedDiet, Integer>{
	
//	PortionedFoodPortionedDiet findByPortionedFoodId(Integer portionedFoodId);
}
