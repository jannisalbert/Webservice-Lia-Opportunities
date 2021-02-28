package se.albertssonmueller.webservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import se.albertssonmueller.webservice.dtos.StatusDto;
import se.albertssonmueller.webservice.services.StatusService;

import java.util.List;
import java.util.Optional;

@RestController
public class StatusController {

	private final StatusService statusService;

	public StatusController(StatusService statusService) {
		this.statusService = statusService;
	}

	@GetMapping("/status")
	public List<StatusDto> all() {
		return statusService.getAllStatus();
	}

	@GetMapping("/status/{id}")
	public Optional<StatusDto> getOne(@PathVariable Long id) {

		return Optional.ofNullable(statusService.getOneStatus(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Status-Id " + id + " not found.")));
	}
}