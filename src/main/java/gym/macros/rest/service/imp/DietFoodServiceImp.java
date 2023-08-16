package gym.macros.rest.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import gym.macros.entity.Diet;
import gym.macros.entity.DietFood;
import gym.macros.entity.Food;
import gym.macros.entity.PortionedFood;
import gym.macros.entity.PortionedFoodDiet;
import gym.macros.rest.repository.DietFoodRepository;
import gym.macros.rest.repository.DietRepository;
import gym.macros.rest.repository.PortionedFoodDietRepository;
import gym.macros.rest.service.DietFoodService;

@Service
public class DietFoodServiceImp implements DietFoodService{

	@Autowired
	private DietFoodRepository dietFoodRepo;
	
	@Autowired
	private DietRepository dietRepo;
	
	@Autowired
	private PortionedFoodDietRepository portionedFoodDietRepo;
	
	@Override
	public void saveDietFood(Diet realDiet, List<Food> aux, List<PortionedFood> aux2) {
		
		PortionedFoodDiet pfd = new PortionedFoodDiet();
		
		Diet diet = dietRepo
					.findById(realDiet.getId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Diet id not found."));
		
		
		for (int i=0; i>aux.size(); i++) {
			DietFood dietFood = new DietFood();
			dietFood.setDietId(diet);
			dietFood.setFoodId(aux.get(i));
			
			dietFoodRepo.save(dietFood);
			
			pfd.setDietCalorie(pfd.getDietCalorie() + aux2.get(i).getCalorie());
			pfd.setDietGram(pfd.getDietGram() +  aux2.get(i).getGram());
		}
		
		pfd.setDiet(diet);
		pfd.setPortionedFood(aux2);
		portionedFoodDietRepo.save(pfd);
	}

}
