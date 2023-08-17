package gym.macros.rest.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gym.macros.entity.PortionedFood;
import gym.macros.entity.PortionedFoodDiet;
import gym.macros.entity.PortionedFoodPortionedDiet;
import gym.macros.rest.repository.PortionedFoodPortionedDietRepository;
import gym.macros.rest.service.PortionedFoodPortionedDietService;

@Service
public class PortionedFoodPortionedDietServiceImp implements PortionedFoodPortionedDietService{

	@Autowired
	private PortionedFoodPortionedDietRepository repo;
	
	@Override
	public void savePortionedFoodPortionedDiet(List<PortionedFood> portionedFoods, PortionedFoodDiet portionedDiet) {
		
		portionedFoods.forEach(foods -> {
			
			PortionedFoodPortionedDiet pfpd = new PortionedFoodPortionedDiet();
			
			pfpd.setPortionedFoodId(foods);
			pfpd.setPortionedFoodDietId(portionedDiet);
			repo.save(pfpd);
			
		});
	}

}
