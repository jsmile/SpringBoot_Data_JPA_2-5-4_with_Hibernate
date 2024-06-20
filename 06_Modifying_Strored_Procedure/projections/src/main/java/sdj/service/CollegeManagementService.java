package sdj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sdj.entity.Guide;
import sdj.projection.GuideNameSalary;
import sdj.repository.GuideRepository;

@Service
public class CollegeManagementService {
	
	@Autowired
	private GuideRepository guideRepository;
	
	public void populateDb() {		
        Guide guide1 = new Guide("2000MO10789", "Mike Lawson", 1000);
        Guide guide2 = new Guide("2008IM10901", "Ian Lamb", 4000);
        Guide guide3 = new Guide("2012DO10777", "David Crow", 3000);
        Guide guide4 = new Guide("2020HN10865", "Henry Smith", 2000);
        Guide guide5 = new Guide("2021DO10499", "Diane Lynn", 3500);
        Guide guide6 = new Guide("2017ES50489", "Eric Walsh", 2500);
        
        guideRepository.saveAll( List.of(guide1, guide2, guide3, guide4, guide5, guide6) );
	}
	
	@Transactional(readOnly = true)
	public void displayNameAndSalaryOfFirst3GuidesBySalaryGreaterThan2000() {
        List<GuideNameSalary> proxies = guideRepository.findFirst3BySalaryGreaterThan(2000); 
        
        for (GuideNameSalary proxy : proxies) {
            System.out.println("Name: " + proxy.getName() + "\t\t Salary: " + proxy.getSalary());
        }
	}
	
	@Transactional(readOnly = true)
	public void displayInfoOfFirst3GuidesBySalaryGreaterThan2000() {
        List<GuideNameSalary> proxies = guideRepository.findFirst3BySalaryGreaterThan(2000); 
        
        for (GuideNameSalary proxy : proxies) {
            System.out.println(proxy.getInfo());
        }
	}
	
}
