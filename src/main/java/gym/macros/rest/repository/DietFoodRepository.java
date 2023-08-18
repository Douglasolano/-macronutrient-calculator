package gym.macros.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gym.macros.entity.DietFood;
import jakarta.transaction.Transactional;

public interface DietFoodRepository extends JpaRepository<DietFood, Integer>{
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM tb_diet_food WHERE diet_id = :id", nativeQuery = true)
	void deleteDietFood(@Param("id") Integer id);
}
