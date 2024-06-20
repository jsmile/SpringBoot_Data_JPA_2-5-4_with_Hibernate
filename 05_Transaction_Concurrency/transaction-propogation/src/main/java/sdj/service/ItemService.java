package sdj.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sdj.entity.Item;
import sdj.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private LoggingService loggingService;
	
	@Transactional( propagation = Propagation.REQUIRED )
	public void persistAnItem() {		
		Item item = new Item("Item1", LocalDate.of(2022, 5, 1), 29);
		itemRepository.save(item);
		
		loggingService.logAMessage( "adding item with name " + item.getName());		
	}
	
}
