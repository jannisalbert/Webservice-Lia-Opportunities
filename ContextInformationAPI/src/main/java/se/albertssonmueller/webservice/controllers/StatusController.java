package se.albertssonmueller.webservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import se.albertssonmueller.webservice.dtos.StatusDto;
import se.albertssonmueller.webservice.services.Service;

import java.util.List;
import java.util.Optional;

@RestController
public class StatusController {

	private final Service service;

	public StatusController(Service service) {
		this.service = service;
	}

	@GetMapping("/status")
	public List<StatusDto> all(Long id) {
		return service.getAllStatus();
	}

	@GetMapping("/status/{id}")
	public Optional<StatusDto> getOne(@PathVariable Long id) {

		return Optional.ofNullable(service.getOneStatus(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Id " + id + " not found.")));
	}
}