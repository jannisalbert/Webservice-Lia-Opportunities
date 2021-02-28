package se.albertssonmueller.webservice.services;

import se.albertssonmueller.webservice.dtos.PriorityDto;
import se.albertssonmueller.webservice.dtos.StatusDto;

import java.util.List;
import java.util.Optional;

public interface PriorityService {

	List<PriorityDto> getAllPriorities();

	Optional<PriorityDto> getOnePriority(Long id);

}
