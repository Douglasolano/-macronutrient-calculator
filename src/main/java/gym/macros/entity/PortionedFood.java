package gym.macros.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_portioned_food")
public class PortionedFood {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="portioned_food_id")
	private Integer id;
	
	@JoinColumn(name = "food_id")
	private Integer food;
	
	@Column(name = "portioned_food_name")
	private String name;
	
	@Column(name = "portioned_food_gram")
	private Double gram;
	
	@Column(name = "portioned_food_calorie")
	private Double calorie; 
	
	@Column(name = "portioned_food_carbohydrate")
	private Double carbohydrate;
	
	@Column(name = "portioned_food_protein")
	private Double protein;
	
	@Column(name = "portioned_food_fat")
	private Double fat;

	public PortionedFood() {
		super();
	}

	public PortionedFood(Integer id, Integer food, String name, Double gram, Double calorie, Double carbohydrate,
			Double protein, Double fat) {
		super();
		this.id = id;
		this.food = food;
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

	public Integer getFood() {
		return food;
	}

	public void setFood(Integer food) {
		this.food = food;
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
		return "PortionedFood [id=" + id + ", food=" + food + ", name=" + name + ", gram=" + gram + ", calorie="
				+ calorie + ", carbohydrate=" + carbohydrate + ", protein=" + protein + ", fat=" + fat + "]";
	}
}
