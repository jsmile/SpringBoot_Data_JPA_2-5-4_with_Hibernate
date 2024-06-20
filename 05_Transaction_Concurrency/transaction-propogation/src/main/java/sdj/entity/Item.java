package sdj.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDate creationDate;

    private Integer price;

    public Item() {}
    public Item(String name, LocalDate creationDate, Integer price) {
		this.name = name;
		this.creationDate = creationDate;
		this.price = price;
	}
    
    public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", price=" + price
				+ "]";
	}

}
