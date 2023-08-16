package gym.macros.entity.dto;

public class FoodDTO {

	private Integer id;
	private Integer gram;

	public FoodDTO() {
		super();
	}
	
	public FoodDTO(Integer id, Integer gram) {
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

	public Integer getGram() {
		return gram;
	}

	public void setGram(Integer gram) {
		this.gram = gram;
	}
}
