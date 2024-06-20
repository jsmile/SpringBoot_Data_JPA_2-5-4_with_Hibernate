package entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
//@DynamicUpdate
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name="enrollment_id", nullable = false, unique=true)
	private String enrollmentId;

	public Student() {}
	public Student(String enrollmentId, String name) {
		this.enrollmentId = enrollmentId;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Student other = (Student) obj;
		return Objects.equals(id, other.id);
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", enrollmentId=" + enrollmentId + ", name=" + name + "]";
	}

}
