package gym.macros.rest.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import gym.macros.entity.Diet;
import gym.macros.entity.Food;
import gym.macros.entity.PortionFood;
import gym.macros.entity.dto.DietDTO;
import gym.macros.rest.repository.DietRepository;
import gym.macros.rest.repository.FoodRepository;
import gym.macros.rest.repository.PortionFoodRepository;
import gym.macros.rest.service.DietService;

@Service
public class DietServiceImp implements DietService{
	
	@Autowired
	private DietRepository dietRepo;
	
	@Autowired
	private FoodRepository foodRepo;
	
	@Autowired
	private PortionFoodRepository portionFoodRepo;

	@Override
	public Diet saveDiet(DietDTO diet) {
		
		Diet realDiet = new Diet();
		
		realDiet.setName(diet.getName());
		
		ArrayList<Integer> foodId = new ArrayList();
		List<PortionFood> portionFoodList = new ArrayList<>();
		
		diet.getFood().forEach(f -> {
			
			PortionFood portionFood = new PortionFood();
			Food portionedFood = new Food();
			Integer grams = f.getGram();
			
			Food realFood = foodRepo.findById(f.getFood())
									.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Food id not found"));
			
			portionedFood.setName(realFood.getName());
			portionedFood.setCalorie(realFood.getCalorie() * grams);
			portionedFood.setCarbohydrate(realFood.getCarbohydrate() * grams);
			portionedFood.setFat(realFood.getFat() * grams);
			portionedFood.setProtein(realFood.getProtein() * grams);
			
			foodId.add(realFood.getId());
			
			portionFood.setFood(realFood);
			realDiet.setCalorie(realDiet.getCalorie() + portionedFood.getCalorie());
			
			portionFoodRepo.save(portionFood);
		});
		
		foodId.forEach( f -> {
			
			PortionFood pf = portionFoodRepo.findById(f).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Food id not found."));
			portionFoodList.add(pf);
			
		});
		
		portionFoodList.forEach(food -> {
			food.setGram(diet.getFood().get(0).getGram());
		});
		
		realDiet.setFood(portionFoodList);
		dietRepo.save(realDiet);
		
		return null;
	}

}
