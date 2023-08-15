package gym.macros.entity.dto;

import java.util.List;

public class DietDTO {

	private String name;
	private List<PortionFoodDTO> food;
	
	public DietDTO() {
		super();
	}
	
	public DietDTO(String name, List<PortionFoodDTO> food) {
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

	public List<PortionFoodDTO> getFood() {
		return food;
	}

	public void setFood(List<PortionFoodDTO> food) {
		this.food = food;
	}
}
