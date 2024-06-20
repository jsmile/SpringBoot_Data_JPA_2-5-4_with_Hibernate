package sdj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sdj.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {
	
}
