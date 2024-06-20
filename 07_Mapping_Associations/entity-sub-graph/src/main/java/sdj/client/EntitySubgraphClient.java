package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import sdj.service.CollegeManagementService;

@Component
public class EntitySubgraphClient implements ApplicationRunner {
	
	@Autowired
	private CollegeManagementService cMService;

	@Override
	public void run(ApplicationArguments args) throws Exception {	
		
		//prepopulating db
		cMService.prepopulatingDbWithSomeGuideStudentAndHostelData();
		
		//loading Guide[id=2L] and its associated "students"
		cMService.foo();

	}	

}