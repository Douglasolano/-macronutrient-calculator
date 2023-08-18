package gym.macros.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gym.macros.entity.PortionedFood;
import jakarta.transaction.Transactional;

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
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM tb_portioned_food WHERE portioned_food_id = :id", nativeQuery = true)
	void deletePortionedFood(@Param("id") Integer id);

//	@Query(value="SELECT  \r\n"
//			+ "TB_PORTIONED_FOOD.*\r\n"
//			+ "\r\n"
//			+ "FROM \r\n"
//			+ "TB_PORTIONED_FOOD,\r\n"
//			+ "TB_PORTIONED_FOOD_PORTIONED_DIET, \r\n"
//			+ "TB_DIET_FOOD \r\n"
//			+ "WHERE\r\n"
//			+ "TB_PORTIONED_FOOD_PORTIONED_DIET.PORTIONED_FOOD_ID = TB_PORTIONED_FOOD.PORTIONED_FOOD_ID \r\n"
//			+ "AND TB_DIET_FOOD.DIET_ID = TB_PORTIONED_FOOD_PORTIONED_DIET.PORTIONED_FOOD_DIET_ID\r\n"
//			+ "AND TB_PORTIONED_FOOD_PORTIONED_DIET.PORTIONED_FOOD_DIET_ID  = :id", nativeQuery = true)
//	public List<PortionedFood> findPortionedFoodId(@Param("id") Integer id);
}
