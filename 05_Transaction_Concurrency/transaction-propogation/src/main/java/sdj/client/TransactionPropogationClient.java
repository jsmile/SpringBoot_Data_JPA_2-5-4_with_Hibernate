package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import sdj.service.ItemService;

@Component
public class TransactionPropogationClient implements ApplicationRunner {
	
	@Autowired
	private ItemService itemService;

	@Override
	public void run(ApplicationArguments args) throws Exception {	

		itemService.persistAnItem();
       
	}

}