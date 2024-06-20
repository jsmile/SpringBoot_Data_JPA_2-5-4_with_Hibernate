package sdj.entity;

import javax.persistence.Entity;

@Entity

public class Paperback extends Book {

    private String size;
    private String weight;

    public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}

    @Override
    public String toString() {
        return super.toString() + ", Paperback{" + "size=" + size + ", weight=" + weight + '}';
    }

}
