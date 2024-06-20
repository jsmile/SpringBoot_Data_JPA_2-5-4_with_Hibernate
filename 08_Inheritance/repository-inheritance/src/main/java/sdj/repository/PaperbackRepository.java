package sdj.repository;

import org.springframework.stereotype.Repository;

import sdj.entity.Paperback;

@Repository
public interface PaperbackRepository extends BookBaseRepository<Paperback> {
	
}
