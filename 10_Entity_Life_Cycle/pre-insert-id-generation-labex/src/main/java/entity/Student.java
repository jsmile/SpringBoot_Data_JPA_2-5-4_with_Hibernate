package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;

@Entity
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
	
	@PostPersist
	public void foo() {
		System.out.println("Student[id=" + this.id + "] just got persisted.");
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", enrollmentId=" + enrollmentId + ", name=" + name + "]";
	}

}
