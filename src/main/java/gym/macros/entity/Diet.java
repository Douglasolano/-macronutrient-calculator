package gym.macros.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
	@Column(name="diet_food")
	private List<PortionFood> food;

	public Diet() {
		super();
	}

	public Diet(Integer id, String name, Double calorie, List<PortionFood> food) {
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

	public List<PortionFood> getFood() {
		return food;
	}

	public void setFood(List<PortionFood> food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "Diet [id=" + id + ", name=" + name + ", calorie=" + calorie + ", food=" + food + "]";
	}
}
