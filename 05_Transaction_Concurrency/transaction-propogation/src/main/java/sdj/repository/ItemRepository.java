package sdj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sdj.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {	
	
}
