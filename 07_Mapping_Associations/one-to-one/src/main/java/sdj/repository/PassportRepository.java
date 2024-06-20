package sdj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sdj.entity.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long> {
	
}
