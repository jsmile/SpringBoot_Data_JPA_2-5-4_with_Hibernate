package sdj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sdj.entity.Guide;
import sdj.repository.GuideRepository;

@Service
public class CollegeManagementService {
	
	@Autowired
	private GuideRepository guideRepository;
	
	@Transactional
	public void prepareNameAndSalaryReportOfAllGuides() {
		
		//select guide.name, guide.salary from Guide guide
		List<Object[]> resultList = guideRepository.getNameAndSalaryOfAll();
		for (Object[] object : resultList) {
			System.out.println("Name: " + object[0] + "\t\t Salary: " + object[1]);
		}		
		
		//select sum(guide.salary) from Guide guide
		System.out.println("The total salary of all the guides is " + guideRepository.calculateSumOfAllSalaries());
		
		//update Guide guide set guide.salary = guide.salary * 2
		System.out.println( guideRepository.doubleSalaryOfAll() );		

	}
	
	@Transactional
	public void raiseSalaryOfGuide(Long id, Integer newSalary) {		
		
		Guide guide = guideRepository.findById( id ).get(); 
		guide.setSalary(newSalary);		
		
	}
	
}
