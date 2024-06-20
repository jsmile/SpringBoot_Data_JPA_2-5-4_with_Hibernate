package sdj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sdj.entity.Hostel;

public interface HostelRepository extends JpaRepository<Hostel, Long> {
	
}
