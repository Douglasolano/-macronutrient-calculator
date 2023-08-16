package gym.macros.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gym.macros.entity.DietFood;

public interface DietFoodRepository extends JpaRepository<DietFood, Integer>{
}
