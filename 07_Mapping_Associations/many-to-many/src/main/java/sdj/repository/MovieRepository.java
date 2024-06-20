package sdj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sdj.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
}
