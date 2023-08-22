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
import gym.macros.rest.service.DietFoodService;
import gym.macros.rest.service.DietService;
import gym.macros.rest.service.PortionedFoodPortionedDietService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "gymNutrition/diet")
public class DietController {
	
	@Autowired
	private DietService dietService;
	
	@Autowired
	private PortionedFoodPortionedDietService portionedFoodPortionedDietServ;
	
	@Autowired
	private DietFoodService dietFoodServ;
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PortionedFoodDietDTO getDietById(@PathVariable("id") Integer id) {
		return portionedFoodPortionedDietServ.findByIdPortionedDiet(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void postDiet(@RequestBody @Valid DietDTO dietDTO) {
		dietService.saveDiet(dietDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDiet(@PathVariable("id") Integer id) {
		dietFoodServ.deleteDietFood(id);
	}
	
	public static class ErrorResponse {
        private int status;
        private String message;

        public ErrorResponse(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
