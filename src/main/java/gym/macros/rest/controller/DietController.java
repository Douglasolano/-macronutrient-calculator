package gym.macros.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gym.macros.entity.dto.DietDTO;
import gym.macros.entity.dto.PortionedFoodDietDTO;
import gym.macros.rest.repository.DietFoodRepository;
import gym.macros.rest.repository.DietRepository;
import gym.macros.rest.repository.PortionedFoodDietRepository;
import gym.macros.rest.repository.PortionedFoodPortionedDietRepository;
import gym.macros.rest.repository.PortionedFoodRepository;
import gym.macros.rest.service.DietService;
import gym.macros.rest.service.PortionedFoodPortionedDietService;
import gym.macros.rest.service.PortionedFoodService;

@RestController
@RequestMapping(value = "gymNutrition/diet")
public class DietController {

	@Autowired
	private DietRepository dietRepo;
	
	@Autowired
	private DietFoodRepository dietFoodRepo;

	@Autowired
	private PortionedFoodPortionedDietRepository repo;
	
	@Autowired
	private PortionedFoodRepository portionedFoodRepo;
	
	@Autowired
	private PortionedFoodDietRepository portionedFoodDietRepo;

	@Autowired
	private DietService dietService;
	
	@Autowired
	private PortionedFoodPortionedDietService portionedFoodPortionedDietServ;
	
	@Autowired
	private PortionedFoodService portionedFoodServ;
	
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
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDiet(@PathVariable("id") Integer id) {
		repo.deletePortionedFoodPortonedDiet(id);
//		portionedFoodServ.deletePortionedFoodService(id);
		dietFoodRepo.deleteDietFood(id);
		portionedFoodDietRepo.deletePortionedFoodDiet(id);
		dietRepo.deleteById(id);
	}
}
