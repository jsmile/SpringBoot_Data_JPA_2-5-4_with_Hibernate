package sdj.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	private String name;
	
	private String email;
	
	@OneToOne(cascade={CascadeType.PERSIST} , fetch = FetchType.LAZY )
	@JoinColumn(name="passport_id", unique = true)
	private Passport passport;
	
	public Customer() {}	
	public Customer(String name, String email, Passport passport) {
		this.name = name;
		this.email = email;
		this.passport = passport;
	}
	
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public Passport getPassport() {
		return passport;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}	