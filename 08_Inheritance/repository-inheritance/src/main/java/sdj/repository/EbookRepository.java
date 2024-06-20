package sdj.repository;

import org.springframework.stereotype.Repository;

import sdj.entity.Ebook;

@Repository
public interface EbookRepository extends BookBaseRepository<Ebook> {
	
}
