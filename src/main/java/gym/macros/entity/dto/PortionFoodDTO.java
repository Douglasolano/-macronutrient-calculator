package gym.macros.entity.dto;

public class PortionFoodDTO {

	private Integer gram;
	private Integer food;
	
	public PortionFoodDTO() {
		super();
	}

	public PortionFoodDTO(Integer gram, Integer food) {
		super();
		this.gram = gram;
		this.food = food;
	}

	public Integer getGram() {
		return gram;
	}

	public void setGram(Integer gram) {
		this.gram = gram;
	}

	public Integer getFood() {
		return food;
	}

	public void setFood(Integer food) {
		this.food = food;
	}
}
