package sdj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import sdj.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByIsActive( Boolean isActive );
	
	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query(" delete from User u where u in :users ")
	Integer deleteInBulk( List<User> users );	
	
}
