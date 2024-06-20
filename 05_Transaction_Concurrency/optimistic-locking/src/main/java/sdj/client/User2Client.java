package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Component;

import sdj.entity.Guide;
import sdj.service.CollegeManagementService;

@Component
public class User2Client implements Runnable {

	@Autowired
	private CollegeManagementService cMService;

	@Override
	public void run() {
		
		Guide guide = cMService.findGuideById( 2L );
		guide.setSalary(4000);
		try {
			cMService.updateGuide(guide);	
		} catch (ObjectOptimisticLockingFailureException e) {
			System.out.println("\033[0;31m" + "Sorry, someone else modified the same data; please restart your conversation.");
		}
		
	}
	
}
