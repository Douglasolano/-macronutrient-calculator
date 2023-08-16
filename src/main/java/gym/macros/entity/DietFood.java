package gym.macros.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_diet_food")
public class DietFood {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "diet_id")
	private Diet dietId;
	
	@ManyToOne
	@JoinColumn(name = "food_id")	
	private Food foodId;

	public DietFood() {	
		super();
	}

	public DietFood(Integer id, Diet dietId, Food foodId) {
		super();
		this.id = id;
		this.dietId = dietId;
		this.foodId = foodId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Diet getDietId() {
		return dietId;
	}

	public void setDietId(Diet dietId) {
		this.dietId = dietId;
	}

	public Food getFoodId() {
		return foodId;
	}

	public void setFoodId(Food foodId) {
		this.foodId = foodId;
	}

	@Override
	public String toString() {
		return "DietFood [id=" + id + ", dietId=" + dietId + ", foodId=" + foodId + "]";
	}
}
