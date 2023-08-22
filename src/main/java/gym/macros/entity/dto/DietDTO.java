package gym.macros.entity.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class DietDTO {

	@NotEmpty(message = "Diet name is required.")
	private String name;
	private List<FoodDTO> food;
	
	public DietDTO() {
		super();
	}
	
	public DietDTO(String name, List<FoodDTO> food) {
		super();
		this.name = name;
		this.food = food;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FoodDTO> getFood() {
		return food;
	}

	public void setFood(List<FoodDTO> food) {
		this.food = food;
	}
}
