package sdj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import sdj.entity.Book;

@NoRepositoryBean
public interface BookBaseRepository<T extends Book> extends JpaRepository<T, Long> {

    T findByTitle(String title);

}
