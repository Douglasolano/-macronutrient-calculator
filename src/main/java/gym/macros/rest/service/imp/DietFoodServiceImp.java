package gym.macros.rest.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import gym.macros.entity.Diet;
import gym.macros.entity.DietFood;
import gym.macros.entity.Food;
import gym.macros.rest.repository.DietFoodRepository;
import gym.macros.rest.repository.DietRepository;
import gym.macros.rest.service.DietFoodService;

@Service
public class DietFoodServiceImp implements DietFoodService{

	@Autowired
	private DietFoodRepository dietFoodRepo;
	
	@Autowired
	private DietRepository dietRepo;
	
	@Override
	public void saveDietFood(Diet realDiet, List<Food> aux) {
		
		Diet diet = dietRepo
					.findById(realDiet.getId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Diet id not found."));
		
		aux.forEach(food -> {
			
			DietFood dietFood = new DietFood();
			dietFood.setDietId(diet);
			dietFood.setFoodId(food);
			dietFoodRepo.save(dietFood);
		});
		
	}

}
