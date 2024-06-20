package sdj.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    private String message;
    
    private LocalDate date;

    public Log() {}
    public Log(String message) {
        this.message = message;
        this.date = LocalDate.now();
    }

	@Override
	public String toString() {
		return "Log [id=" + id + ", message=" + message + ", date=" + date + "]";
	}    
    
}
