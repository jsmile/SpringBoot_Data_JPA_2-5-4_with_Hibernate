package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import sdj.service.BookStoreService;

@Component
public class RepositoryInheritanceClient implements ApplicationRunner {
	
	@Autowired
	private BookStoreService bSService;

	@Override
	public void run(ApplicationArguments args) throws Exception {	
		
		//persisting books
		bSService.persistBooks();			
	
		//finding books by title
		bSService.findBooksByTitle();	

	}	

}