package sdj.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;

@Entity
@NamedEntityGraph(
	  name = "Guide.students.hostel",
	  attributeNodes = {
	    @NamedAttributeNode(value="students", subgraph = "hostel-subgraph")
	  },
	  subgraphs = {
		  @NamedSubgraph(
			  name="hostel-subgraph",
			  attributeNodes = {
				  @NamedAttributeNode("hostel")
			  }
			)
	  }
)
public class Guide {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy="guide", cascade= {CascadeType.PERSIST})
	private Set<Student> students = new HashSet<Student>();
	
	@Column(nullable=false)
	private String name;
	
	@Column(name="staff_id", nullable=false, unique=true)
	private String staffId;
	
	private Integer salary;

	public Guide() {}
	public Guide(String staffId, String name, Integer salary) {
		this.staffId = staffId;
		this.name = name;
		this.salary = salary;
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
		student.setGuide(this);
	}
	public void removeStudent(Student student) {
		this.students.remove(student);
		student.setGuide(null);
	}
	public void removeStudents() {
		Iterator<Student> iterator = this.students.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			student.setGuide(null);
			iterator.remove();
		}
	}

	public String getStaffId() {
		return staffId;
	}
	public Set<Student> getStudents() {
		return students;
	}
	
	@Override
	public String toString() {
		return "Guide [id=" + id + ", name=" + name + ", staffId=" + staffId + ", salary=" + salary + "]";
	}
	
}
