package se.albertssonmueller.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import se.albertssonmueller.webservice.dtos.OpportunityDto;
import se.albertssonmueller.webservice.entities.Opportunity;


@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {


}
