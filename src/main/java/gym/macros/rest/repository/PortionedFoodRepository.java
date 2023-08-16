package gym.macros.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gym.macros.entity.PortionedFood;

public interface PortionedFoodRepository extends JpaRepository<PortionedFood, Integer>{

}
