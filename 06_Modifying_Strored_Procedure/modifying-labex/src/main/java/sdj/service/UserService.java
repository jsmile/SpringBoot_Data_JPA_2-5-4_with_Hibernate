package sdj.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.jpa.internal.PersistenceUnitUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sdj.entity.User;
import sdj.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void persistUsers() {		
		User user1 = new User("john", LocalDate.of(2021, Month.AUGUST, 4), "john@somewhr.com", 1, true);
		User user2 = new User("jane", LocalDate.of(2019, Month.MARCH, 18), "jane@somewhr.com", 2, true);
		User user3 = new User("nicole", LocalDate.of(2017, Month.JULY, 21), "nicole@somewhr.com", 1, false);
		User user4 = new User("ravi", LocalDate.of(2018, Month.JUNE, 15), "ravi@somewhr.com", 1, false);
		User user5 = new User("alissa", LocalDate.of(2014, Month.APRIL, 5), "alissa@somewhr.com", 2, true);
		
		userRepository.saveAll( List.of(user1, user2, user3, user4, user5) );
	}
	
	@Transactional
	public void deleteInBulkAllInActiveUsers() {		
		List<User> inactiveUsers = userRepository.findByIsActive( false );
		
		//manually defined in UserRepository
		userRepository.deleteInBulk( inactiveUsers );
		
		//inherited from JpaRepository
		//userRepository.deleteAllInBatch( inactiveUsers );
	}
	
}
