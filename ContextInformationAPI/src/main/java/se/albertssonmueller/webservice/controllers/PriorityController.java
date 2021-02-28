package se.albertssonmueller.webservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import se.albertssonmueller.webservice.dtos.PriorityDto;
import se.albertssonmueller.webservice.services.PriorityService;

import java.util.List;
import java.util.Optional;

@RestController
public class PriorityController {

	private final PriorityService priorityService;

	public PriorityController(PriorityService priorityService) {
		this.priorityService = priorityService;
	}

	@GetMapping("/priorities")
	public List<PriorityDto> all() {
		return priorityService.getAllPriorities();
	}

	@GetMapping("/priorities/{id}")
	public Optional<PriorityDto> getOne(@PathVariable Long id) {

		return Optional.ofNullable(priorityService.getOnePriority(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Priority-Id " + id + " not found.")));
	}

}
