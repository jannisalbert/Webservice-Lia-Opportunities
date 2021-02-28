package se.albertssonmueller.webservice.services;


import se.albertssonmueller.webservice.dtos.OpportunityDto;

import java.util.List;
import java.util.Optional;

public interface Service {

    List<OpportunityDto> getAllOpportunities();

    Optional<OpportunityDto> getOne(Long id);

    OpportunityDto createOpportunity(OpportunityDto directorDto);

    void delete(Long id);

    OpportunityDto replace(Long id, OpportunityDto directorDto);

}

