package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import sdj.service.CollegeManagementService;

@Component
public class Question1Client implements ApplicationRunner {
	
	@Autowired
	private CollegeManagementService cMService;

	@Override
	public void run(ApplicationArguments args) throws Exception {	
		
		//persisting
		cMService.persistingAGuideAlongWithItsAssociatedStudents();
		
		//disconnect all students from Guide[id=1L] and then removing it from STUDENT table too
		cMService.foo();

	}	

}