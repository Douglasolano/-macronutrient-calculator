package gym.macros.entity.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class FoodDTO {

	private Integer id;
	private Double gram;

	public FoodDTO() {
		super();
	}
	
	public FoodDTO(Integer id, Double gram) {
		super();
		this.id = id;
		this.gram = gram;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getGram() {
		return gram;
	}

	public void setGram(Double gram) {
		this.gram = gram;
	}
}
