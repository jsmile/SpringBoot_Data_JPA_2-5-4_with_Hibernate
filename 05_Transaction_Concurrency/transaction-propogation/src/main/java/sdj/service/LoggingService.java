package sdj.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sdj.entity.Log;
import sdj.repository.LogRepository;

@Service
public class LoggingService {
	
	@Autowired
	private LogRepository logRepository;
	
	@Transactional( propagation = Propagation.SUPPORTS )
	public void logAMessage(String logMessage) {		
		Log log = new Log(logMessage); 
		logRepository.save(log);		
		
		//for REQUIRED	
		/*
		if(new Random().nextBoolean()) {
			throw new RuntimeException("DummyException: this should cause rollback of both INSERTs (Item and Log)!");
		}
		*/
	}
	
}
