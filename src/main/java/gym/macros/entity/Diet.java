package gym.macros.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_diet")
public class Diet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="diet_name")
	private String name;
	
	@Column(name="diet_calorie")
	private Double calorie = 0.0;
	
	@OneToMany
	@JoinColumn(name = "food_id")
	@Column(name="diet_food")
	@JsonIgnore
	private List<Food> food;

	public Diet() {
		super();
	}

	public Diet(Integer id, String name, Double calorie, List<Food> food) {
		super();
		this.id = id;
		this.name = name;
		this.calorie = calorie;
		this.food = food;
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

	public Double getCalorie() {
		return calorie;
	}

	public void setCalorie(Double calorie) {
		this.calorie = calorie;
	}

	public List<Food> getFood() {
		return food;
	}

	public void setFood(List<Food> food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "Diet [id=" + id + ", name=" + name + ", calorie=" + calorie + ", food=" + food + "]";
	}
}
