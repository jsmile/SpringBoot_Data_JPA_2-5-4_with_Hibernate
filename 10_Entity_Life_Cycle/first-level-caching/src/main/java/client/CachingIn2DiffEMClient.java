package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Student;

public class CachingIn2DiffEMClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();
		
		Student student1 = em1.find(Student.class, 1L);
		
		em1.getTransaction().commit();
		em1.close(); 
		
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();
		
		Student student2 = em2.find(Student.class, 1L);
		
		em2.getTransaction().commit();
		em2.close(); 
	}
}
