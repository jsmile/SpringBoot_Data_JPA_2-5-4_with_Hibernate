package sdj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sdj.entity.Ebook;

public interface EbookRepository extends JpaRepository<Ebook, Long> {

}
