package gym.macros.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_portioned_food_diet")
public class PortionedFoodDiet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "diet_food_id")
	private Diet diet;
	
	@OneToMany
	@JoinColumn(name = "portioned_food_id")
	private List<PortionedFood> portionedFood;
	
	@Column(name = "portioned_food_diet_calorie")
	private Double dietCalorie = 0.0;
	
	@Column(name= "portioned_food_diet_gram")
	private Double dietGram;
	
	public PortionedFoodDiet() {
		super();
	}

	public PortionedFoodDiet(Integer id, Diet diet, Double dietCalorie, Double dietGram, List<PortionedFood> portionedFood) {
		super();
		this.id = id;
		this.diet = diet;
		this.dietCalorie = dietCalorie;
		this.dietGram = dietGram;
		this.portionedFood = portionedFood;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Diet getDiet() {
		return diet;
	}

	public void setDiet(Diet diet) {
		this.diet = diet;
	}

	public Double getDietCalorie() {
		return dietCalorie;
	}

	public Double getDietGram() {
		return dietGram;
	}

	public void setDietGram(Double dietGram) {
		this.dietGram = dietGram;
	}

	public void setDietCalorie(Double dietCalorie) {
		this.dietCalorie = dietCalorie;
	}

	public List<PortionedFood> getPortionedFood() {
		return portionedFood;
	}

	public void setPortionedFood(List<PortionedFood> portionedFood) {
		this.portionedFood = portionedFood;
	}

	@Override
	public String toString() {
		return "PortionedFoodDiet [id=" + id + ", diet=" + diet + ", dietCalorie=" + dietCalorie + ", dietGram="
				+ dietGram + ", portionedFood=" + portionedFood + "]";
	}
}
