package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import sdj.service.CustomerManagementService;

@Component
public class OneToOneClient implements ApplicationRunner {
	
	@Autowired
	private CustomerManagementService cMService;

	@Override
	public void run(ApplicationArguments args) throws Exception {	
		
		//persisting
		cMService.persistingACustomerAlongWithItsPassport();
		
		//finding
		cMService.findingACustomer();

	}	

}