package gym.macros.rest.service;

import java.util.List;

import gym.macros.entity.Diet;
import gym.macros.entity.Food;
import gym.macros.entity.PortionedFood;

public interface DietFoodService{
	void saveDietFood(Diet realDiet, List<Food> aux, List<PortionedFood> aux2);
}
