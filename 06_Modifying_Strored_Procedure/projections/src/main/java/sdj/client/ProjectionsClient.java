package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import sdj.service.CollegeManagementService;

@Component
public class ProjectionsClient implements ApplicationRunner {
	
	@Autowired
	private CollegeManagementService cMService;


	@Override
	public void run(ApplicationArguments args) {	
		
		//pre-populating db
		cMService.populateDb();
		
		//displaying "name" and "salary" of first 3 guides whose salary is > 2000
		cMService.displayNameAndSalaryOfFirst3GuidesBySalaryGreaterThan2000();
		
		//displaying "info" of first 3 guides whose salary is > 2000
		cMService.displayInfoOfFirst3GuidesBySalaryGreaterThan2000();
         
	}

}