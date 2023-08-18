package gym.macros.rest.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gym.macros.entity.PortionedFood;
import gym.macros.rest.repository.PortionedFoodPortionedDietRepository;
import gym.macros.rest.repository.PortionedFoodRepository;
import gym.macros.rest.service.PortionedFoodService;

@Service
public class PortionedFoodServiceImp implements PortionedFoodService{

	@Autowired
	private PortionedFoodRepository portionedFoodRepo;

	@Override
	public void deletePortionedFoodService(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void deletePortionedFoodService(Integer id) {
//		
//		List<PortionedFood> pf =  portionedFoodRepo.findPortionedFoodId(id);
//		
//		pf.forEach(p -> {
//			portionedFoodRepo.deletePortionedFood(p.getId());
//		});
//		
//	}
}
