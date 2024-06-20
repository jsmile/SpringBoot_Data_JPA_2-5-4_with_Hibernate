package sdj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import sdj.entity.Employee;
import sdj.projection.EmployeeNameSalary;
import sdj.repository.EmployeeRepository;

@Service
public class OfficeManagementService {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private EmployeeRepository employeeRepository;

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
		Integer count = employeeRepository.foo("Engineering");
		System.out.println("count: " + count);
	}

	@Transactional
	public void findEmployeeByDepartment() {
		List<Employee> empList = employeeRepository.bar("Engineering");
		for (Employee employee : empList) {
			System.out.println(employee);
		}
	}
	
	@Transactional
	public void findNameAndSalaryeByDepartment() {
		List<EmployeeNameSalary> proxies = employeeRepository.zar("Engineering");
		for (EmployeeNameSalary proxy : proxies) {
			System.out.println("Name: " + proxy.getName() + "\t\t Salary: " + proxy.getSalary());
		}
	}
	
}
