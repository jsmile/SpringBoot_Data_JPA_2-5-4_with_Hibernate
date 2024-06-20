package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Student;

public class Question1Client {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Student student = new Student("2003CH50897", "Kevin Smith");
		em.persist(student);

		Student studentByFind = em.find(Student.class, student.getId());

		Student studentByJpql = (Student) em.createQuery("select s from Student s where s.id = :id").setParameter("id", student.getId()).getSingleResult();

		em.getTransaction().commit();
		em.close();
	}
}