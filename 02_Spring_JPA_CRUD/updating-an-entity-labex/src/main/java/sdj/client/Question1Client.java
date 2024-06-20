package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import sdj.entity.Student;
import sdj.repository.StudentRepository;

@Component
public class Question1Client implements ApplicationRunner {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {		
		  Student student1 = new Student("Alisa Simmons", "2022AN50123"); 
		  Student student2 = studentRepository.save(student1);
		  System.out.println(student1.equals(student2));
		  
		  student2.setName("Alissa Simmons"); 
		  Student student3 = studentRepository.save(student2);	
		  System.out.println(student2.equals(student3));
		  System.out.println(student1.equals(student3));
	}

}