package sdj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sdj.entity.Dog;

public interface DogRepository extends JpaRepository<Dog, Long> {
	
	@Query("select d from Dog d")
	List<Dog> findAll();
	
}
