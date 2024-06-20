package sdj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sdj.entity.Log;

public interface LogRepository extends JpaRepository<Log, Long> {
	
}
