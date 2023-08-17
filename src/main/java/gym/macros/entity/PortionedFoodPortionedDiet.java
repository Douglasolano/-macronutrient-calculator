package gym.macros.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_portioned_food_portined_diet")
public class PortionedFoodPortionedDiet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "portioned_food_diet_id")	
	private PortionedFoodDiet portionedFoodDietId;

	@ManyToOne
	@JoinColumn(name = "portioned_food_id")
	private PortionedFood portionedFoodId;
	
	public PortionedFoodPortionedDiet() {
		super();
	}
	
	public PortionedFoodPortionedDiet(Integer id, PortionedFood portionedFoodId,
			PortionedFoodDiet portionedFoodDietId) {
		super();
		this.id = id;
		this.portionedFoodId = portionedFoodId;
		this.portionedFoodDietId = portionedFoodDietId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PortionedFood getPortionedFoodId() {
		return portionedFoodId;
	}

	public void setPortionedFoodId(PortionedFood portionedFoodId) {
		this.portionedFoodId = portionedFoodId;
	}

	public PortionedFoodDiet getPortionedFoodDietId() {
		return portionedFoodDietId;
	}

	public void setPortionedFoodDietId(PortionedFoodDiet portionedFoodDietId) {
		this.portionedFoodDietId = portionedFoodDietId;
	}

	@Override
	public String toString() {
		return "PortionedFoodPortionedDiet [id=" + id + ", portionedFoodId=" + portionedFoodId
				+ ", portionedFoodDietId=" + portionedFoodDietId + "]";
	}
}
