package gym.macros.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gym.macros.entity.dto.DietDTO;
import gym.macros.entity.dto.PortionedFoodDietDTO;
import gym.macros.rest.service.DietService;
import gym.macros.rest.service.PortionedFoodPortionedDietService;

@RestController
@RequestMapping(value = "gymNutrition/diet")
public class DietController {

//	@Autowired
//	private DietRepository dietRepo;
	
	@Autowired
	private DietService dietService;
	
	@Autowired
	private PortionedFoodPortionedDietService portionedFoodPortionedDietServ;
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PortionedFoodDietDTO getDietById(@PathVariable("id") Integer id) {
		return portionedFoodPortionedDietServ.findByIdPortionedDiet(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void postDiet(@RequestBody DietDTO dietDTO) {
		dietService.saveDiet(dietDTO);
	}
}
