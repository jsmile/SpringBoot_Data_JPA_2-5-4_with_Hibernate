package sdj.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public void persistingAStudentAlongWithItsAssociatedGuide() {
		Guide guide = new Guide("2000MO10789", "Mike Lawson", 1000);
		Student student = new Student("2014JT50123", "John Smith", guide);
	
		//guideRepository.save( guide );
		studentRepository.save( student );
	}
	
	@Transactional
	public void findingAStudentByItsId() {
		Student student = studentRepository.findById(1L).get();
		System.out.println(student);
		System.out.println(student.getGuide().getStaffId());
	}

}
