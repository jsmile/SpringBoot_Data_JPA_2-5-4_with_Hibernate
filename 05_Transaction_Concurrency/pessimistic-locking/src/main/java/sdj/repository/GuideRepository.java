package sdj.repository;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import sdj.entity.Guide;

public interface GuideRepository extends JpaRepository<Guide, Long> {	
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select guide.name, guide.salary from Guide guide")
	List<Object[]> getNameAndSalaryOfAll();
	
	@Query("select sum(guide.salary) from Guide guide")
	Long calculateSumOfAllSalaries();	
	
	@Transactional
	@Modifying
	@Query("update Guide guide set guide.salary = guide.salary * 2")
	Integer doubleSalaryOfAll();
	
}
