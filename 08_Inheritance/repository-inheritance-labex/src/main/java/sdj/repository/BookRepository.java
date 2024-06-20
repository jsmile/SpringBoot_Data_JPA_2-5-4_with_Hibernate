package sdj.repository;

import org.springframework.stereotype.Repository;

import sdj.entity.Book;

@Repository
public interface BookRepository extends BookBaseRepository<Book> {
	
}
