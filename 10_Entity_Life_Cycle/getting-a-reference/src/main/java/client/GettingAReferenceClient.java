package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

import entity.Student;

public class GettingAReferenceClient {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Student student = em.getReference(Student.class, 3L);
		long studentId = student.getId();
		String studentName = student.getName();
		
		em.getTransaction().commit();
		em.close(); 
	}
}
