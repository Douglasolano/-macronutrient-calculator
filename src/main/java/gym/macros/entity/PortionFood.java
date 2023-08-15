package gym.macros.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_portion_food")
public class PortionFood {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "portion_food_gram")
	private Integer gram;
	
	@OneToOne
	private Food food;

	public PortionFood() {
		super();
	}

	public PortionFood(Integer id, Integer gram, Food food) {
		super();
		this.id = id;
		this.gram = gram;
		this.food = food;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGram() {
		return gram;
	}

	public void setGram(Integer gram) {
		this.gram = gram;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "PortionFood [id=" + id + ", gram=" + gram + ", food=" + food + "]";
	}
}
