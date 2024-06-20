package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import sdj.service.OfficeManagementService;

@Component
public class Question1Client implements ApplicationRunner {
	
	@Autowired
	private OfficeManagementService oMService;

	@Override
	public void run(ApplicationArguments args) throws Exception {	
		
		//prepopulating db
		oMService.prepopulatingDb();
		
		//counting the no. of employees in a particular department
		oMService.countEmployeeByDepartment();

	}	

}