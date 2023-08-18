package gym.macros.rest.service;

import java.util.List;

import gym.macros.entity.PortionedFood;
import gym.macros.entity.PortionedFoodDiet;
import gym.macros.entity.dto.PortionedFoodDietDTO;

public interface PortionedFoodPortionedDietService {

	void savePortionedFoodPortionedDiet(List<PortionedFood> portionedFoods, PortionedFoodDiet portionedDiet);
	
	PortionedFoodDietDTO findByIdPortionedDiet(Integer id);
}
