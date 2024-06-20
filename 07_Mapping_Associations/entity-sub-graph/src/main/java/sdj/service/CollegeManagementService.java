package sdj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sdj.entity.Guide;
import sdj.entity.Hostel;
import sdj.entity.Student;
import sdj.repository.GuideRepository;
import sdj.repository.HostelRepository;
import sdj.repository.StudentRepository;

@Service
public class CollegeManagementService {

	@Autowired
	private GuideRepository guideRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public void prepopulatingDbWithSomeGuideStudentAndHostelData() {
		Guide guide1 = new Guide("2000MO10789", "Mike Lawson", 1000);
		Guide guide2 = new Guide("2000IM10901", "Ian Lamb", 2000);
		Guide guide3 = new Guide("2000DO10777", "David Crow", 3000);
		
		Student student1 = new Student("2014AL50456", "Amy Gill");
		Student student2 = new Student("2014JT50123", "John Smith");
		Student student3 = new Student("2014BE50789", "Bruce Lee");
		Student student4 = new Student("2014RG50347", "Rahul Singh");
		
		Hostel hostel1 = new Hostel("Yellow Doors");
		Hostel hostel2 = new Hostel("Wake up Sydney");
		
		guide2.addStudent(student1);
		guide2.addStudent(student2);
		guide3.addStudent(student4);
		
		student1.setHostel(hostel1);
		student2.setHostel(hostel1);
		student3.setHostel(hostel2);
		student4.setHostel(hostel2);
        
        guideRepository.save(guide1);
        guideRepository.save(guide2);   
        studentRepository.save(student3);
        guideRepository.save(guide3);
	}

	@Transactional(readOnly = true)
	public void foo() {
		Guide guide = guideRepository.findById(2L).get();
		System.out.println(guide);
	}

}
