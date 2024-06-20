package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import sdj.service.UserService;

@Component
public class ModifyingClient implements ApplicationRunner {
	
	@Autowired
	private UserService userService;

	@Override
	public void run(ApplicationArguments args) throws Exception {	

		//populating db
		userService.persistUsers();
		
		//deleting users one-by-one by level
		userService.deleteUsersByLevel();
       
		//deleting users in-bulk by level
		userService.deleteUsersInBulkByLevel();
		
	}

}