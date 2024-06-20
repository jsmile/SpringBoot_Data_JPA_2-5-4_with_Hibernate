package sdj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import sdj.entity.Employee;

@Service
public class OfficeManagementService {

	@Autowired
	private EntityManager em;

	@Transactional
	public void prepopulatingDb() {
		Employee emp1 = new Employee("Mark Young", 5000, "Engineering");
		Employee emp2 = new Employee("Olivia Goy", 4500, "Accounting");
		Employee emp3 = new Employee("Joana Tom", 5500, "QA");
		Employee emp4 = new Employee("Alicia Nimar", 5000, "Engineering");
		Employee emp5 = new Employee("Katy Loin", 4500, "Engineering");
		Employee emp6 = new Employee("Rahul Singh", 4500, "Engineering");
		
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		em.persist(emp4);
		em.persist(emp5);
		em.persist(emp6);
	}

	@Transactional
	public void countEmployeeByDepartment() {
		StoredProcedureQuery q = em.createStoredProcedureQuery("count_employee_by_department");
		q.registerStoredProcedureParameter("p_dept", String.class, ParameterMode.IN);
		q.registerStoredProcedureParameter("p_count", Integer.class, ParameterMode.OUT);
		q.setParameter("p_dept", "Engineering");
		q.execute();
		Integer count = (Integer) q.getOutputParameterValue("p_count");
		System.out.println("count: " + count);
	}
}
