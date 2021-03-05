package se.albertssonmueller.webservice.dtos;

public class LeadDto {

	private OpportunityDto opportunityDto;
	private CompanyDto companyDto;
	private ContactDto contactDto;
	private PriorityDto priorityDto;
	private StatusDto statusDto;

	public LeadDto(OpportunityDto opportunityDto, CompanyDto companyDto, ContactDto contactDto, PriorityDto priorityDto, StatusDto statusDto) {
		this.opportunityDto = opportunityDto;
		this.companyDto = companyDto;
		this.contactDto = contactDto;
		this.priorityDto = priorityDto;
		this.statusDto = statusDto;
	}

	public LeadDto() {
	}

	public OpportunityDto getOpportunityDto() {
		return opportunityDto;
	}

	public void setOpportunityDto(OpportunityDto opportunityDto) {
		this.opportunityDto = opportunityDto;
	}

	public CompanyDto getCompanyDto() {
		return companyDto;
	}

	public void setCompanyDto(CompanyDto companyDto) {
		this.companyDto = companyDto;
	}

	public ContactDto getContactDto() {
		return contactDto;
	}

	public void setContactDto(ContactDto contactDto) {
		this.contactDto = contactDto;
	}

	public PriorityDto getPriorityDto() {
		return priorityDto;
	}

	public void setPriorityDto(PriorityDto priorityDto) {
		this.priorityDto = priorityDto;
	}

	public StatusDto getStatusDto() {
		return statusDto;
	}

	public void setStatusDto(StatusDto statusDto) {
		this.statusDto = statusDto;
	}
}
