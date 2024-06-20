package sdj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@Column(name="passport_number")
	private String passportNumber;
	
	@Column(name="country_code")
	private String countryCode;
	
	@OneToOne(mappedBy="passport" , fetch = FetchType.LAZY )
	private Customer customer;

	public Passport() {}
	public Passport(String passportNumber, String countryCode) {
		this.passportNumber = passportNumber;
		this.countryCode = countryCode;
	}	
	public Customer getCustomer() {
		return customer;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	
	public void addCustomer(Customer customer) {
		this.customer = customer;
		customer.setPassport(this);
	}
	public void removeCustomer(Customer customer) {
		this.customer = null;
		customer.setPassport(null);
	}
	
	@Override
	public String toString() {
		return "Passport [id=" + id + ", passportNumber=" + passportNumber + ", countryCode=" + countryCode + "]";
	}
	
}