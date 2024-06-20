package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import sdj.service.ZooManagementService;

@Component
public class InheritanceClient implements ApplicationRunner {
	
	@Autowired
	private ZooManagementService zMService;

	@Override
	public void run(ApplicationArguments args) throws Exception {	
		
		//persisting a Cat and a Dog
		zMService.persistingACatAndADog();		

		//finding all animals (polymorphic query)
		zMService.findAllAnimals();
		
		//finding all dogs (querying concrete sub-class)
		zMService.findAllDogs();
	}	

}