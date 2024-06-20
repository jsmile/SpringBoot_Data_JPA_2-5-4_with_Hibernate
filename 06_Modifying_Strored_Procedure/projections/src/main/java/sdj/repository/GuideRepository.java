package sdj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sdj.entity.Guide;
import sdj.projection.GuideNameSalary;

public interface GuideRepository extends JpaRepository<Guide, Long> {	

	@Query(value="select g.name, g.salary from Guide g where g.salary > :salary limit 3", nativeQuery = true)
	List<GuideNameSalary> findFirst3BySalaryGreaterThan(Integer salary);

}
