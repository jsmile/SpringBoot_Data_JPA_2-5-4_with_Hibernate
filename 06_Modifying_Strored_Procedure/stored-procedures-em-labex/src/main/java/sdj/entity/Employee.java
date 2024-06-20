package sdj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

//@NamedStoredProcedureQueries({
//    @NamedStoredProcedureQuery(
//            name = "CountByDepartmentProcedure",
//            procedureName = "count_employee_by_department",
//            parameters = {
//                    @StoredProcedureParameter(
//                            name = "dept",
//                            type = String.class,
//                            mode = ParameterMode.IN),
//                    @StoredProcedureParameter(
//                            name = "count",
//                            type = Integer.class,
//                            mode = ParameterMode.OUT)
//            }
//    )
//})
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer salary;
    
    private String department;

    public Employee() {}
	public Employee(String name, Integer salary, String department) {
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	} 
    
}
