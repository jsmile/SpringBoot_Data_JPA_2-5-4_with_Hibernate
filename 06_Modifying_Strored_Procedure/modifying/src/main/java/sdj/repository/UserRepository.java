package sdj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import sdj.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Transactional
	Integer deleteByLevel(Integer level);
	
	@Transactional
	@Modifying
	@Query("delete from User u where u.level = :level")
	Integer deleteInBulkByLevel(Integer level);		
	
}
