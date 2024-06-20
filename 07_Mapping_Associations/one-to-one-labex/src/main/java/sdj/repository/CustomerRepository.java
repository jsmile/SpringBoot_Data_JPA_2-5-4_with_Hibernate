package sdj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sdj.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
