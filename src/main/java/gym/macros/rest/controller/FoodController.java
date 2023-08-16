package gym.macros.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gym.macros.entity.Food;
import gym.macros.rest.repository.FoodRepository;
import gym.macros.rest.service.FoodService;

@RestController
@RequestMapping(value = "gymNutrition/food")
public class FoodController {

	@Autowired
	private FoodRepository foodRepo;
	
	@Autowired
	private FoodService foodServ;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Food> getFood() {
		return foodRepo.findAll();
	}
	
	@PostMapping()
	@ResponseStatus(value = HttpStatus.CREATED)
	public void postFood(@RequestBody Food food) {
		foodServ.saveFood(food);
	}
	
}
