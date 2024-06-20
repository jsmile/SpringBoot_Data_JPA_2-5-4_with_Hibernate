package sdj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sdj.entity.Animal;
import sdj.entity.Cat;
import sdj.entity.Dog;
import sdj.repository.AnimalRepository;
import sdj.repository.CatRepository;
import sdj.repository.DogRepository;

@Service
public class ZooManagementService {

	@Autowired
	private CatRepository catRepository;
	
	@Autowired
	private DogRepository dogRepository;
	
	@Autowired
	private AnimalRepository animalRepository;

	@Transactional
	public void persistingACatAndADog() {  			
		Cat cat = new Cat(); 
		cat.setName("Lucy");

		Dog dog = new Dog();
		dog.setName("Oliver");

		catRepository.save(cat);
		dogRepository.save(dog);	
	}
	
	@Transactional(readOnly = true)
	public void findAllAnimals() {  			
		List<Animal> animals = animalRepository.findAll();
		for (Animal animal : animals) {
			System.out.println(animal);
		}
	}
	
	@Transactional(readOnly = true)
	public void findAllDogs() {  			
		List<Dog> dogs = dogRepository.findAll();
		for (Dog dog : dogs) {
			System.out.println(dog);
		}
	}

}
