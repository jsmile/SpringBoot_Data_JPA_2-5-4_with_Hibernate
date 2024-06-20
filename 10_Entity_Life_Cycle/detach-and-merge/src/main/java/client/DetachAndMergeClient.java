package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Student;

public class DetachAndMergeClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();
		
		Student student = em1.find(Student.class, 4L);
		em1.detach(student);
		 
		em1.getTransaction().commit();
		em1.close(); 
		
		student.setName( "Sara New1" );
		
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();
		
		Student mergedStudent = em2.merge(student);
		 
		em2.getTransaction().commit();
		em2.close(); 
	}
}
