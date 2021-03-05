package se.albertssonmueller.webservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import se.albertssonmueller.webservice.dtos.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class LeadController {

	public final String urlOpportunities = "http://opportunities:5053/opportunities/";
	public final String urlCompanies = "http://companies:5050/companies/";
	public final String urlContacts = "http://contacts:5051/contacts/";
	public final String urlPrio = "http://contextinfo:5052/priorities/";
	public final String urlStatus = "http://contextinfo:5052/status/";

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@GetMapping("/leads/{id}")
	public LeadDto getLead(@PathVariable long id) {

		// Finds the opportunity
		OpportunityDto opportunityDto = getOneOpportunity(id);

		// Which Ids to find in the other services
		long companyId = opportunityDto.getCompanyId();
		long contactId = opportunityDto.getContactId();
		long statusId = opportunityDto.getStatusId();
		long priorityId = opportunityDto.getPriorityId();

		// Search for the ids in the other APIs
		CompanyDto companyDto = getOneCompany(companyId);
		ContactDto contactDto = getOneContact(contactId);
		StatusDto statusDto = getStatus(statusId);
		PriorityDto priorityDto = getPriority(priorityId);

		// Return to client
		//		return new OpportunityDto(statusDto, companyDto, contactDto.getGenre(), priorityDto.getLanguage());

		return new LeadDto(opportunityDto, companyDto, contactDto, priorityDto, statusDto);
	}

	@GetMapping("/leads")
	public List<LeadDto> getAllLeads() {

		OpportunityDto[] allOpportunities = getAllOpportunities();
		List<CompanyDto> allCompanies = Arrays.asList(getAllCompanies());
		List<ContactDto> allContacts = Arrays.asList(getAllContacts());
		List<PriorityDto> allPriorities = Arrays.asList(getAllPriorities());
		List<StatusDto> allStatus = Arrays.asList(getAllStatus());

		List<LeadDto> allLeads = new ArrayList<>();

		for (OpportunityDto opportunity : allOpportunities) {
			LeadDto newLead = new LeadDto();

			newLead.setOpportunityDto(opportunity);
			newLead.setCompanyDto(allCompanies.get(( (int) opportunity.getCompanyId()) ));
			newLead.setContactDto(allContacts.get( (int) opportunity.getContactId() ));
			newLead.setPriorityDto(allPriorities.get( (int) opportunity.getPriorityId() ));
			newLead.setStatusDto(allStatus.get( (int) opportunity.getStatusId() ));

			allLeads.add(newLead);
		}
		return allLeads;
	}

	// TODO Replace with Generic methods (one for getOne, one for getAll). Implement below.
//	public <T> T getAllApi(Class<T> type, String url) {
//
//		//		return restTemplate.getForObject(moviesUrl, MovieDto[].class);
//		return restTemplate.getForObject(url, type);
//	}

	public OpportunityDto[] getAllOpportunities() {

		return restTemplate.getForObject(urlOpportunities, OpportunityDto[].class);
	}

	public CompanyDto[] getAllCompanies() {

		return restTemplate.getForObject(urlCompanies, CompanyDto[].class);
	}

	public ContactDto[] getAllContacts() {

		return restTemplate.getForObject(urlContacts, ContactDto[].class);
	}

	public PriorityDto[] getAllPriorities() {

		return restTemplate.getForObject(urlPrio, PriorityDto[].class);
	}

	public StatusDto[] getAllStatus() {

		return restTemplate.getForObject(urlStatus, StatusDto[].class);
	}


	public OpportunityDto getOneOpportunity(long id) {
		return restTemplate.getForObject(urlOpportunities + id, OpportunityDto.class);
	}

	public CompanyDto getOneCompany(long id) {
		return restTemplate.getForObject(urlCompanies + id, CompanyDto.class);
	}

	public ContactDto getOneContact(long id) {
		return restTemplate.getForObject(urlContacts + id, ContactDto.class);
	}

	public StatusDto getStatus(long id) {

		return restTemplate.getForObject(urlStatus + id, StatusDto.class);

	}

	public PriorityDto getPriority(long id) {
		return restTemplate.getForObject(urlPrio + id, PriorityDto.class);
	}
}




