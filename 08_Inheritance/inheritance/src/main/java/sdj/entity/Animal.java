package sdj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
//@Inheritance(strategy=InheritanceType.JOINED) 
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) 
public abstract class Animal {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) // use GenerationType.SEQUENCE for TABLE_PER_CLASS strategy
	private Long id;
	
	@Column(nullable=false)
	private String name;	
	
	public void setName(String name) { 	
		this.name = name; 
	}
	
	public abstract String makeNoise();
	
	public String toString() {
		return name + " making " + makeNoise() + " noises";
	}	

}
