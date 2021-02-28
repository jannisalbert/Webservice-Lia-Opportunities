package se.albertssonmueller.webservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import se.albertssonmueller.webservice.dtos.*;
import se.albertssonmueller.webservice.service.LeadService;


@RestController
public class LeadController {

	LeadService leadService;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/leads/{id}")
	public OpportunityDto getLead(@PathVariable long id) {

		// Finds the object which holds references to the other movies
		StatusDto statusDto = getOneOpportunity(id);

		// Which Ids to find in the other services
		long genreId = statusDto.getGenreId();
		long languageId = statusDto.getLanguageId();
		long directorId = statusDto.getDirectorId();

		// Search for the ids in the other APIs
		ContactDto contactDto = getOneGenre(genreId);
		PriorityDto priorityDto = getOneLanguage(languageId);
		CompanyDto companyDto = getOneDirector(directorId);

		// Return to client
		return new OpportunityDto(statusDto, companyDto, contactDto.getGenre(), priorityDto.getLanguage());

	}
	
	public StatusDto getOneOpportunity(long id) {
		final String uri = "http://localhost:5054/movies/" + id;

		return restTemplate.getForObject(uri, StatusDto.class);

	}

	public CompanyDto getOneDirector(long id) {

		final String uri = "http://localhost:5050/directors/" + id;

		return restTemplate.getForObject(uri, CompanyDto.class);


	}

	public ContactDto getOneGenre(long id) {

		final String uri = "http://localhost:5053/genre/" + id;

		return restTemplate.getForObject(uri, ContactDto.class);

	}

	public PriorityDto getOneLanguage(long id) {

		final String uri = "http://localhost:5052/languages/" + id;

		return restTemplate.getForObject(uri, PriorityDto.class);

	}


}




