package gym.macros.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gym.macros.entity.PortionedFood;

public interface PortionedFoodRepository extends JpaRepository<PortionedFood, Integer>{
	
	@Query(value="SELECT \r\n"
			+ "TB_PORTIONED_FOOD.*\r\n"
			+ "\r\n"
			+ "FROM \r\n"
			+ "TB_PORTIONED_FOOD_PORTIONED_DIET,\r\n"
			+ "TB_PORTIONED_FOOD\r\n"
			+ "\r\n"
			+ "WHERE\r\n"
			+ "TB_PORTIONED_FOOD_PORTIONED_DIET.PORTIONED_FOOD_ID = TB_PORTIONED_FOOD.PORTIONED_FOOD_ID\r\n"
			+ "AND TB_PORTIONED_FOOD_PORTIONED_DIET.PORTIONED_FOOD_DIET_ID = :id", nativeQuery = true)
	public List<PortionedFood> findPortionedFood(@Param("id") Integer id);
	
//	public List<PortionedFood> findByFood(Integer food);

}
