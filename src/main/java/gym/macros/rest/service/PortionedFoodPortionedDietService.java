package gym.macros.rest.service;

import java.util.List;

import gym.macros.entity.PortionedFood;
import gym.macros.entity.PortionedFoodDiet;

public interface PortionedFoodPortionedDietService {

	void savePortionedFoodPortionedDiet(List<PortionedFood> portionedFoods, PortionedFoodDiet portionedDiet);
}
