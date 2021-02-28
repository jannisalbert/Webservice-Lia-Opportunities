package se.albertssonmueller.webservice.service;

import se.albertssonmueller.webservice.dtos.OpportunityDto;

import java.util.List;

public interface LeadService {

    List<OpportunityDto> getAll();
}
