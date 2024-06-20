package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Component;

import sdj.entity.Guide;
import sdj.service.CollegeManagementService;

@Component
public class User1Client implements Runnable {

	@Autowired
	private CollegeManagementService cMService;

	@Override
	public void run() {
		
		Guide guide = cMService.findGuideById( 2L );
		guide.setSalary(3000);
		try {
			cMService.updateGuide(guide);	
		} catch (ObjectOptimisticLockingFailureException e) {
			System.out.println("\033[0;31m" + "The Guide#2 was updated by some other user, while you were occupied with something else.");
		}
		
	}
	
}
