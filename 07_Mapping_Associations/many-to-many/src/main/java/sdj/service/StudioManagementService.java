package sdj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sdj.entity.Actor;
import sdj.entity.Movie;
import sdj.repository.ActorRepository;

@Service
public class StudioManagementService {

	@Autowired
	private ActorRepository actorRepository;

	@Transactional
	public void persistingActorsAlongWithItsMovies() {
		Movie movie1 = new Movie("American Hustle");
		Movie movie2 = new Movie("The Prestige");

		Actor actor1 = new Actor("Christian Bale");
		Actor actor2 = new Actor("Hugh Jackman");
		
		actor1.addMovie(movie1);
		actor1.addMovie(movie2);
		
		actor2.addMovie(movie2);
		
		actorRepository.save(actor1);
		actorRepository.save(actor2);		
	}
	
	@Transactional
	public void findingAnActor() {
		Actor actor = actorRepository.findById( 1L ).get();
		System.out.println( actor.getMovies().isEmpty() );
	}


}
