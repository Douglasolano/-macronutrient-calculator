package gym.macros.rest.service;

import java.util.List;

import gym.macros.entity.Diet;
import gym.macros.entity.Food;

public interface DietFoodService{
	void saveDietFood(Diet realDiet, List<Food> aux);
}
