package gym.macros.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gym.macros.entity.PortionedFood;
import gym.macros.entity.PortionedFoodDiet;
import jakarta.transaction.Transactional;

public interface PortionedFoodDietRepository extends JpaRepository<PortionedFoodDiet, Integer>{
	
	@Query(value="SELECT \r\n"
			+ "TB_PORTIONED_FOOD_DIET.ID,\r\n"
			+ "TB_PORTIONED_FOOD_DIET.DIET_FOOD_ID,\r\n"
			+ "TB_PORTIONED_FOOD_DIET.PORTIONED_FOOD_DIET_CALORIE,\r\n"
			+ "TB_PORTIONED_FOOD_DIET.PORTIONED_FOOD_DIET_GRAM\r\n"
			+ "\r\n"
			+ "FROM \r\n"
			+ "TB_PORTIONED_FOOD_PORTIONED_DIET,\r\n"
			+ "TB_PORTIONED_FOOD_DIET\r\n"
			+ "\r\n"
			+ "WHERE\r\n"
			+ "TB_PORTIONED_FOOD_PORTIONED_DIET.PORTIONED_FOOD_DIET_ID = TB_PORTIONED_FOOD_DIET.DIET_FOOD_ID\r\n"
			+ "AND ROWNUM = 1\r\n"
			+ "AND TB_PORTIONED_FOOD_DIET.DIET_FOOD_ID = :id", nativeQuery = true)
	public PortionedFoodDiet findPortionedFoodDiet(@Param("id") Integer id);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM TB_PORTIONED_FOOD_DIET WHERE diet_food_id = :id", nativeQuery = true)
	void deletePortionedFoodDiet(@Param("id") Integer id);
	
}
