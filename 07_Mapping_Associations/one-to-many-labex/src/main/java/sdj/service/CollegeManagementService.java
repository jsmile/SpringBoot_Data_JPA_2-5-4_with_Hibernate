package sdj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sdj.entity.Guide;
import sdj.entity.Student;
import sdj.repository.GuideRepository;

@Service
public class CollegeManagementService {

	@Autowired
	private GuideRepository guideRepository;

	@Transactional
	public void persistingAGuideAlongWithItsAssociatedStudents() {
        Guide guide1 = new Guide("2000MO10789", "Mike Lawson", 1000);
        Guide guide2 = new Guide("2000IM10901", "Ian Lamb", 2000);
        
        Student student1 = new Student("2014JT50123", "John Smith", guide1);
        Student student2 = new Student("2014AL50456", "Amy Gill", guide1);
        
        guide1.addStudent(student1);
        guide1.addStudent(student2);
        
        guideRepository.save(guide1);
        guideRepository.save(guide2);        
	}

	@Transactional
	public void foo() {
		Guide guide1 = guideRepository.findById(1L).get();
		guide1.removeStudents();
	}

}
