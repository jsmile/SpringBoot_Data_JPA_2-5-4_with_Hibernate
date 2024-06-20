package sdj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hostel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	public Hostel() {}	
	public Hostel(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Hostel [id=" + id + ", name=" + name + "]";
	}
}
