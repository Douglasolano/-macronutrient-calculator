package gym.macros.rest.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gym.macros.entity.PortionedFood;
import gym.macros.entity.PortionedFoodDiet;
import gym.macros.entity.PortionedFoodPortionedDiet;
import gym.macros.entity.dto.PortionedFoodDTO;
import gym.macros.entity.dto.PortionedFoodDietDTO;
import gym.macros.rest.repository.PortionedFoodDietRepository;
import gym.macros.rest.repository.PortionedFoodPortionedDietRepository;
import gym.macros.rest.repository.PortionedFoodRepository;
import gym.macros.rest.service.PortionedFoodPortionedDietService;

@Service
public class PortionedFoodPortionedDietServiceImp implements PortionedFoodPortionedDietService{

	@Autowired
	private PortionedFoodPortionedDietRepository repo;
	
	@Autowired
	private PortionedFoodRepository portionedFoodRepo;
	
	@Autowired
	private PortionedFoodDietRepository portionedFoodDietRepo;
	
	@Override
	public void savePortionedFoodPortionedDiet(List<PortionedFood> portionedFoods, PortionedFoodDiet portionedDiet) {
		
		portionedFoods.forEach(foods -> {
			
			PortionedFoodPortionedDiet pfpd = new PortionedFoodPortionedDiet();
			
			pfpd.setPortionedFoodId(foods);
			pfpd.setPortionedFoodDietId(portionedDiet);
			repo.save(pfpd);
			
		});
	}

	@Override
	public PortionedFoodDietDTO findByIdPortionedDiet(Integer id) {
		
		List<PortionedFood> portionedFood = portionedFoodRepo.findPortionedFood(id);
		PortionedFoodDiet portionedFoodDiet = portionedFoodDietRepo.findPortionedFoodDiet(id);
		
		List<PortionedFoodDTO> listpfDTO = new ArrayList<PortionedFoodDTO>();
		
		int contador = portionedFood.size();
		
		for (int i=0; i<contador; i++ ) {
			
			PortionedFoodDTO pfDTO = new PortionedFoodDTO();
			
			pfDTO.setCalorie((double) Math.round(portionedFood.get(i).getCalorie()));
			pfDTO.setCarbohydrate((double) Math.round(portionedFood.get(i).getCarbohydrate()));
			pfDTO.setFat((double) Math.round(portionedFood.get(i).getFat()));
			pfDTO.setFoodId(portionedFood.get(i).getFood().getId());
			pfDTO.setGram(portionedFood.get(i).getGram());
			pfDTO.setName(portionedFood.get(i).getName());
			pfDTO.setPortionedFoodId(portionedFood.get(i).getId());
			pfDTO.setProtein((double) Math.round(portionedFood.get(i).getProtein()));
			
			listpfDTO.add(pfDTO);
			
		}
		
		PortionedFoodDietDTO pfdDTO = new PortionedFoodDietDTO();
		
		pfdDTO.setDietId(portionedFoodDiet.getDiet().getId());
		pfdDTO.setDietCalorie((double) Math.round(portionedFoodDiet.getDietCalorie()));
		pfdDTO.setDietGram(portionedFoodDiet.getDietGram());
		pfdDTO.setPortionedFoodDietId(portionedFoodDiet.getId());
		pfdDTO.setPortionedFood(listpfDTO);
		
		
		return pfdDTO;
	}

}
