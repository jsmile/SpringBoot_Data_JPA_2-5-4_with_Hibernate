package sdj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sdj.entity.Cat;

public interface CatRepository extends JpaRepository<Cat, Long> {
	
	@Query("select c from Cat c")
	List<Cat> findAll();
	
}
