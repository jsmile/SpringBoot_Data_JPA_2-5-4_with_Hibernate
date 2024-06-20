package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import sdj.service.CollegeManagementService;

@Component
public class OneToManyClient implements ApplicationRunner {
	
	@Autowired
	private CollegeManagementService cMService;

	@Override
	public void run(ApplicationArguments args) throws Exception {	
		
		//persisting
		cMService.persistingAGuideAlongWithItsAssociatedStudents();
		
		//finding
		cMService.findingAGuideByItsId();
		
		//updating the inverse-end
		cMService.updatingAGuide();
		
		//updating the owner
		cMService.updatingAStudent();
	}	

}