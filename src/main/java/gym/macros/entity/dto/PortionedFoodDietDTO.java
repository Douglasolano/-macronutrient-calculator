package gym.macros.entity.dto;

import java.util.List;
import java.util.Objects;

public class PortionedFoodDietDTO {

	private Integer portionedFoodDietId;
	
	private Integer dietId;
	
	private Double dietCalorie;
	
	private Double dietGram;
	
	private List<PortionedFoodDTO> portionedFood;

	public PortionedFoodDietDTO() {
		super();
	}

	public PortionedFoodDietDTO(Integer portionedFoodDietId, Integer dietId, Double dietCalorie, Double dietGram,
			List<PortionedFoodDTO> portionedFood) {
		super();
		this.portionedFoodDietId = portionedFoodDietId;
		this.dietId = dietId;
		this.dietCalorie = dietCalorie;
		this.dietGram = dietGram;
		this.portionedFood = portionedFood;
	}

	public Integer getPortionedFoodDietId() {
		return portionedFoodDietId;
	}

	public void setPortionedFoodDietId(Integer portionedFoodDietId) {
		this.portionedFoodDietId = portionedFoodDietId;
	}

	public Integer getDietId() {
		return dietId;
	}

	public void setDietId(Integer dietId) {
		this.dietId = dietId;
	}

	public Double getDietCalorie() {
		return dietCalorie;
	}

	public void setDietCalorie(Double dietCalorie) {
		this.dietCalorie = dietCalorie;
	}

	public Double getDietGram() {
		return dietGram;
	}

	public void setDietGram(Double dietGram) {
		this.dietGram = dietGram;
	}

	public List<PortionedFoodDTO> getPortionedFood() {
		return portionedFood;
	}

	public void setPortionedFood(List<PortionedFoodDTO> portionedFood) {
		this.portionedFood = portionedFood;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dietCalorie, dietGram, dietId, portionedFood, portionedFoodDietId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortionedFoodDietDTO other = (PortionedFoodDietDTO) obj;
		return Objects.equals(dietCalorie, other.dietCalorie) && Objects.equals(dietGram, other.dietGram)
				&& Objects.equals(dietId, other.dietId) && Objects.equals(portionedFood, other.portionedFood)
				&& Objects.equals(portionedFoodDietId, other.portionedFoodDietId);
	}

	@Override
	public String toString() {
		return "PortionedFoodDietDTO [portionedFoodDietId=" + portionedFoodDietId + ", dietId=" + dietId
				+ ", dietCalorie=" + dietCalorie + ", dietGram=" + dietGram + ", portionedFood=" + portionedFood + "]";
	}
}
