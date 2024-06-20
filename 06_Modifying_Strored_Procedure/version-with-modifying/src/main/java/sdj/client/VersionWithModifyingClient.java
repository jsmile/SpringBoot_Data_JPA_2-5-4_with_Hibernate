package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import sdj.service.UserService;

@Component
public class VersionWithModifyingClient implements ApplicationRunner {
	
	@Autowired
	private UserService userService;

	@Override
	public void run(ApplicationArguments args) throws Exception {	

		//populating db
		userService.persistUsers();
		
		//bulk-updating all the active users registered before Jan 1, 2020
		userService.foo();
		
	}

}