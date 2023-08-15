package gym.macros.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gym.macros.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Integer>{

}
