package sdj.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import sdj.entity.Guide;
import sdj.entity.Student;
import sdj.repository.GuideRepository;
import sdj.repository.StudentRepository;

@Service
public class CollegeManagementService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private GuideRepository guideRepository;

	@Transactional
	public void persistingAGuideAlongWithItsAssociatedStudents() {
        Guide guide1 = new Guide("2000MO10789", "Mike Lawson", 1000);
        Guide guide2 = new Guide("2000IM10901", "Ian Lamb", 2000);
        
        Student student1 = new Student("2014JT50123", "John Smith", guide1);
        Student student2 = new Student("2014AL50456", "Amy Gill", guide1);
        
        guide1.getStudents().add(student1);
        guide1.getStudents().add(student2);
        
        guideRepository.save(guide1);
        guideRepository.save(guide2);        
	}

	@Transactional
	public void findingAGuideByItsId() {
		Guide guide = guideRepository.findById(1L).get();
		System.out.println(guide);
        Set<Student> students = guide.getStudents();
        int numberOfStudents = students.size();
	}
	
	@Transactional
	public void updatingAGuide() {
        Guide guide2 = guideRepository.findById( 2L ).get();  
        
        Student student2 = studentRepository.findById( 2L ).get();          
        guide2.addStudent( student2 );
	}
	
	@Transactional
	public void updatingAStudent() {
        Student student2 = studentRepository.findById( 2L ).get(); 
        
        Guide guide2 = guideRepository.findById( 2L ).get();    
        student2.setGuide(guide2); 
	}

}
