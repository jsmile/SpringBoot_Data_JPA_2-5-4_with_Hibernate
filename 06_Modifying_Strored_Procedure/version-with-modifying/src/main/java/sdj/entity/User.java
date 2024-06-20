package sdj.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Version
    private Integer version;
    
    private String username;

    @Column(name="registration_date")
    private LocalDate registrationDate;

    private Integer level;
    
    @Column(name="active")
    private Boolean isActive;

    public User() {}    
	public User(String username, LocalDate registrationDate, Integer level, Boolean isActive) {
		this.username = username;
		this.registrationDate = registrationDate;
		this.level = level;
		this.isActive = isActive;
	}
	
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", registrationDate=" + registrationDate + ", version="
				+ version + ", level=" + level + ", isActive=" + isActive + "]";
	}

}
