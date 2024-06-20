package sdj.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import sdj.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Transactional
	@Modifying
	@Query(" update versioned User u set u.level = u.level+1 where u.registrationDate < ?1 and u.isActive = true ")
	Integer updateInBulk( LocalDate registrationDate);	
	
}
