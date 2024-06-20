package client;

import java.util.HashMap;

import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Student;

public class CachingClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Student student1 = em.find(Student.class, 1L);
		Student student2 = em.find(Student.class, 1L);
		//updating name of Student[id=1L] in STUDENT table from "Kevin Smith" to "Kevin New1"
		Student student3 = em.find(Student.class, 1L);
		student3.setName("Kevin New2"); 
		String student1Name = student1.getName(); //"Kevin New2"
		em.refresh(student3);
		System.out.println(student3.getName()); //"Kevin New1"
		
		em.getTransaction().commit();
		em.close(); 
	}
}
