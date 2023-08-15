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

import gym.macros.entity.Diet;
import gym.macros.entity.dto.DietDTO;
import gym.macros.rest.repository.DietRepository;
import gym.macros.rest.service.DietService;

@RestController
@RequestMapping(value = "gymNutrition/diet")
public class DietController {

	@Autowired
	private DietRepository dietRepo;
	
	@Autowired
	private DietService dietService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Diet> getDiet() {
		return dietRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void postDiet(@RequestBody DietDTO dietDTO) {
		dietService.saveDiet(dietDTO);
	}
}
