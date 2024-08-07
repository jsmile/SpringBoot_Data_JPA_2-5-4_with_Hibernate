package sdj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

import sdj.entity.Guide;

public interface GuideRepository extends JpaRepository<Guide, Long> {
	
	@EntityGraph(attributePaths = {"students"}, type = EntityGraphType.FETCH)
	Optional<Guide> findById(Long id);
	
}
