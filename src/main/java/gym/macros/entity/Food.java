package gym.macros.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tb_food")
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "food_name", nullable=false)
	@NotEmpty(message = "name is required")
	private String name;
	
	@Column(name = "food_gram")
	private Double gram = 1.0;
	
	@Column(name = "food_calorie")
	@NotNull(message = "calorie is required")
	private Double calorie; 
	
	@Column(name = "food_carbohydrate")
	@NotNull(message = "carbohydrate is required")
	private Double carbohydrate;
	
	@Column(name = "food_protein")
	@NotNull(message = "protein is required")
	private Double protein;
	
	@Column(name = "food_fat")
	@NotNull(message = "fat is required")
	private Double fat;

	public Food() {
		
	}
	
	public Food(Integer id, String name, Double gram, Double calorie, Double carbohydrate, Double protein, Double fat) {
		super();
		this.id = id;
		this.name = name;
		this.gram = gram;
		this.calorie = calorie;
		this.carbohydrate = carbohydrate;
		this.protein = protein;
		this.fat = fat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", gram=" + gram + ", calorie=" + calorie + ", carbohydrate="
				+ carbohydrate + ", protein=" + protein + ", fat=" + fat + "]";
	}
}
