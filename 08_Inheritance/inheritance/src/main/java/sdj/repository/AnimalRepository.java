package sdj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sdj.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
	
	@Query("select a from Animal a")
	List<Animal> findAll();
	
}
