package se.albertssonmueller.webservice.services;


import se.albertssonmueller.webservice.dtos.StatusDto;

import java.util.List;
import java.util.Optional;

public interface Service {

	List<StatusDto> getAllStatus();

	Optional<StatusDto> getOneStatus(Long id);
}

