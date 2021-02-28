package se.albertssonmueller.webservice.dtos;

public class PriorityDto {

	private Long id;
	private String description;

	public PriorityDto() {
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public PriorityDto(Long id, String description) {
		this.id = id;
		this.description = description;
	}

}
