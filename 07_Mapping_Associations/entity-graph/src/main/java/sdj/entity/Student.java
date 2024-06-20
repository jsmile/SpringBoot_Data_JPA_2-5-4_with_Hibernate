package sdj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(name="enrollment_id", nullable=false, unique=true)
	private String enrollmentId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="guide_id")
	private Guide guide;

	public Student() {}	
	public Student(String name, String enrollmentId) {
		this.name = name;
		this.enrollmentId = enrollmentId;
	}
	public Student(String enrollmentId, String name, Guide guide) {
		this.enrollmentId = enrollmentId;
		this.name = name;
		this.guide = guide;
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
	public void setGuide(Guide guide) {
		this.guide = guide;
	}
	public Guide getGuide() {
		return guide;
	}
	public String getEnrollmentId() {
		return enrollmentId;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", enrollmentId=" + enrollmentId + "]";
	}
	
}
