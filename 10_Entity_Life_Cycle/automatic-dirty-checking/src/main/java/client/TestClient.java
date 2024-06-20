package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			
			
			
			txn.commit();
		} catch (Exception ex) {
			// transaction rollback, exception handling ...
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}

	}
}
