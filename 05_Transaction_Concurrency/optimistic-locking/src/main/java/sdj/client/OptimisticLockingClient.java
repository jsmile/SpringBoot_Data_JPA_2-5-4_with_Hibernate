package sdj.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class OptimisticLockingClient implements ApplicationRunner {
	
	@Autowired
	private User1Client user1Client;
	
	@Autowired
	private User2Client user2Client;

	@Override
	public void run(ApplicationArguments args) {	
		
		ExecutorService executor = Executors.newFixedThreadPool (2);
    	executor.execute(user1Client);
    	executor.execute(user2Client);
    	
    	executor.shutdown();
         
	}

}