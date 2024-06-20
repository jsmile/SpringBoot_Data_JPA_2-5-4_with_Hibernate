package sdj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sdj.entity.Paperback;

public interface PaperbackRepository extends JpaRepository<Paperback, Long> {

}
