package gym.macros.entity.dto;

import java.util.Objects;

public class PortionedFoodDTO {
	
	private Integer portionedFoodId;
	
	private Integer foodId;
	
	private String name;
	
	private Double gram;
	
	private Double calorie; 
	
	private Double carbohydrate;
	
	private Double protein;
	
	private Double fat;

	public PortionedFoodDTO() {
		super();
	}

	public PortionedFoodDTO(Integer portionedFoodId, Integer foodId, String name, Double gram, Double calorie,
			Double carbohydrate, Double protein, Double fat) {
		super();
		this.portionedFoodId = portionedFoodId;
		this.foodId = foodId;
		this.name = name;
		this.gram = gram;
		this.calorie = calorie;
		this.carbohydrate = carbohydrate;
		this.protein = protein;
		this.fat = fat;
	}

	public Integer getPortionedFoodId() {
		return portionedFoodId;
	}

	public void setPortionedFoodId(Integer portionedFoodId) {
		this.portionedFoodId = portionedFoodId;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getGram() {
		return gram;
	}

	public void setGram(Double gram) {
		this.gram = gram;
	}

	public Double getCalorie() {
		return calorie;
	}

	public void setCalorie(Double calorie) {
		this.calorie = calorie;
	}

	public Double getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(Double carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public Double getProtein() {
		return protein;
	}

	public void setProtein(Double protein) {
		this.protein = protein;
	}

	public Double getFat() {
		return fat;
	}

	public void setFat(Double fat) {
		this.fat = fat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(calorie, carbohydrate, fat, foodId, gram, name, portionedFoodId, protein);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortionedFoodDTO other = (PortionedFoodDTO) obj;
		return Objects.equals(calorie, other.calorie) && Objects.equals(carbohydrate, other.carbohydrate)
				&& Objects.equals(fat, other.fat) && Objects.equals(foodId, other.foodId)
				&& Objects.equals(gram, other.gram) && Objects.equals(name, other.name)
				&& Objects.equals(portionedFoodId, other.portionedFoodId) && Objects.equals(protein, other.protein);
	}

	@Override
	public String toString() {
		return "PortionedFoodDTO [portionedFoodId=" + portionedFoodId + ", foodId=" + foodId + ", name=" + name
				+ ", gram=" + gram + ", calorie=" + calorie + ", carbohydrate=" + carbohydrate + ", protein=" + protein
				+ ", fat=" + fat + "]";
	}
}
