package gym.macros.rest.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gym.macros.entity.Food;
import gym.macros.rest.exception.BussinesRuleException;
import gym.macros.rest.repository.FoodRepository;
import gym.macros.rest.service.FoodService;

@Service
public class FoodServiceImp implements FoodService{

	@Autowired
	private FoodRepository foodRepo;
	
	@Override
	public void saveFood(Food food) {
		
		if (food.getCalorie() == 0.0) {
			throw new BussinesRuleException("Food calorie cannot be: 0.0");
		}
		
		if( food.getGram() > 1.0 ) {
			food.setGram(food.getGram() / food.getGram());
			food.setCalorie(food.getCalorie() / food.getGram());
			food.setCarbohydrate(food.getCarbohydrate() / food.getGram());
			food.setFat(food.getFat() / food.getGram());
			food.setProtein(food.getProtein() / food.getGram());
			foodRepo.save(food);
			
		} else {
			foodRepo.save(food);
		}
	}
}
