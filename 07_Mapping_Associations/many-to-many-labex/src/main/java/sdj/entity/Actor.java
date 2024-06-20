package sdj.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy="actors", cascade = {CascadeType.PERSIST})
	private Set<Movie> movies = new HashSet<Movie>();
	
	public Actor() {}	
	public Actor(String name) {
		this.name = name;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void addMovie(Movie movie) {
		this.movies.add(movie);
		movie.getActors().add(this);
	}	
	public void removeMovie(Movie movie) {
		this.movies.remove(movie);
		movie.getActors().remove(this);
	}
	
	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + "]";
	}
	
}













