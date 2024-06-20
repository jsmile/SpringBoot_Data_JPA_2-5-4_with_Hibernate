package sdj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

import sdj.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@EntityGraph(attributePaths = {"guide", "hostel"}, type = EntityGraphType.LOAD)
	Optional<Student> findById(Long id);
	
}
