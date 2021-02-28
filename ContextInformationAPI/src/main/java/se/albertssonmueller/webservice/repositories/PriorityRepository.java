package se.albertssonmueller.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.albertssonmueller.webservice.entities.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
}
