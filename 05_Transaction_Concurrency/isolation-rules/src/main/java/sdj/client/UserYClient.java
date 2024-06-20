package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sdj.service.CollegeManagementService;

@Component
public class UserYClient implements Runnable {

	@Autowired
	private CollegeManagementService cMService;

	@Override
	public void run() {
		
		cMService.raiseSalaryOfGuide(3L, 4000);

	}
	
}
