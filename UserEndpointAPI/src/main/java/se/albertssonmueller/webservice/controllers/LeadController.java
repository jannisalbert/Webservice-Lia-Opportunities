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
	public LeadDto getLead(@PathVariable long id) {

		// Finds the opportunity
		OpportunityDto opportunityDto = getOneOpportunity(id);

		// Which Ids to find in the other services
		Long companyId = opportunityDto.getCompanyId();
		Long contactId = opportunityDto.getContactId();
		Long statusId = opportunityDto.getStatusId();
		Long priorityId = opportunityDto.getPriorityId();

		// Search for the ids in the other APIs
		CompanyDto companyDto = getOneCompany(companyId);
		ContactDto contactDto = getOneContact(contactId);
		StatusDto statusDto = getStatus(statusId);
		PriorityDto priorityDto = getPriority(priorityId);

		// Return to client
//		return new OpportunityDto(statusDto, companyDto, contactDto.getGenre(), priorityDto.getLanguage());

		return new LeadDto(opportunityDto,companyDto,contactDto,priorityDto,statusDto);
	}
	
	public OpportunityDto getOneOpportunity(long id) {
		final String uri = "http://localhost:5053/opportunities/" + id;

		return restTemplate.getForObject(uri, OpportunityDto.class);

	}

	public CompanyDto getOneCompany(long id) {

		final String uri = "http://localhost:5050/companies/" + id;

		return restTemplate.getForObject(uri, CompanyDto.class);


	}

	public ContactDto getOneContact(long id) {

		final String uri = "http://localhost:5051/contacts/" + id;

		return restTemplate.getForObject(uri, ContactDto.class);

	}

	public PriorityDto getPriority(long id) {

		final String uri = "http://localhost:5052/priorities/" + id;

		return restTemplate.getForObject(uri, PriorityDto.class);

	}

	public StatusDto getStatus(long id) {

		final String uri = "http://localhost:5052/status/" + id;

		return restTemplate.getForObject(uri, StatusDto.class);

	}


}




