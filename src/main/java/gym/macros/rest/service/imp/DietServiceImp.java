package gym.macros.rest.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import gym.macros.entity.Diet;
import gym.macros.entity.Food;
import gym.macros.entity.PortionedFood;
import gym.macros.entity.dto.DietDTO;
import gym.macros.entity.dto.FoodDTO;
import gym.macros.rest.repository.DietRepository;
import gym.macros.rest.repository.FoodRepository;
import gym.macros.rest.repository.PortionedFoodRepository;
import gym.macros.rest.service.DietFoodService;
import gym.macros.rest.service.DietService;
import jakarta.transaction.Transactional;

@Service
public class DietServiceImp implements DietService{
	
	@Autowired
	private DietRepository dietRepo;
	
	@Autowired
	private FoodRepository foodRepo;
	
	@Autowired
	private DietFoodService dietFoodServ;
	
	@Autowired
	private PortionedFoodRepository portionedFoodRepo;

	@Override
	@Transactional
	public void saveDiet(DietDTO diet) {
	
		List<Food> aux = new ArrayList<Food>();
		List<PortionedFood> aux2= new ArrayList<PortionedFood>();
		
		Diet realDiet = new Diet();
		Double dietTotalCalories = 0.0;
		Double foodTotalCalories = 0.0;
		
		for (FoodDTO food : diet.getFood()) {
			
			Food realFood = foodRepo
							.findById(food.getId())
							.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Food id not found."));
			
			Double foodCalories = realFood.getCalorie();
			Double foodGrams = realFood.getGram();
			
			foodTotalCalories += food.getGram() * (foodCalories * foodGrams);
			
			aux.add(realFood);
			
			PortionedFood pf = new PortionedFood();
			pf.setName(realFood.getName());
			pf.setCalorie(foodTotalCalories);
			pf.setCarbohydrate(realFood.getCarbohydrate() * food.getGram());
			pf.setFat(realFood.getFat() * food.getGram());
			pf.setGram(food.getGram());
			pf.setProtein(realFood.getProtein() * food.getGram());
			pf.setFood(realFood);
			PortionedFood realPortionedFood =  portionedFoodRepo.save(pf);
			aux2.add(realPortionedFood);
		}
		
		realDiet.setCalorie(dietTotalCalories + foodTotalCalories);
		realDiet.setName(diet.getName());
		realDiet.setFood(aux);
		
		Diet savedDiet = dietRepo.save(realDiet);
		dietFoodServ.saveDietFood(savedDiet,aux,aux2);
		
	}
}
