package gym.macros.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gym.macros.entity.PortionedFoodPortionedDiet;
import jakarta.transaction.Transactional;

public interface PortionedFoodPortionedDietRepository extends JpaRepository<PortionedFoodPortionedDiet, Integer>{
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM tb_portioned_food_portioned_diet WHERE portioned_food_diet_id = :portionedFoodId", nativeQuery = true)
	void deletePortionedFoodPortonedDiet(@Param("portionedFoodId")Integer portionedFoodId);
	
}
