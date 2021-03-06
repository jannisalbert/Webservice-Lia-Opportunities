package se.albertssonmueller.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.albertssonmueller.webservice.entities.Status;


@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}
