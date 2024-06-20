package sdj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sdj.entity.Guide;

public interface GuideRepository extends JpaRepository<Guide, Long> {	
	
	//@Lock(LockModeType.PESSIMISTIC_READ)
	@Query("select guide.name, guide.salary from Guide guide")
	List<Object[]> getNameAndSalaryOfAll();
	
	@Query("select sum(guide.salary) from Guide guide")
	Long calculateSumOfAllSalaries();	
	
}
