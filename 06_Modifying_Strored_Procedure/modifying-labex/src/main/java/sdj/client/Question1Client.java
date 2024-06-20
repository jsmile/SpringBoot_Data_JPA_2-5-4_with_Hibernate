package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import sdj.service.UserService;

@Component
public class Question1Client implements ApplicationRunner {
	
	@Autowired
	private UserService userService;

	@Override
	public void run(ApplicationArguments args) throws Exception {	

		//populating db
		userService.persistUsers();
		
		//deleting all inactive users in-bulk
		userService.deleteInBulkAllInActiveUsers();
		
	}

}