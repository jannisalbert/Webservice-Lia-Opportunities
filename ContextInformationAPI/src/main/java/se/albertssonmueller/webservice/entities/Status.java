package se.albertssonmueller.webservice.entities;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;

	public Status() {
	}

	public Status(Long id, String description) {
		this.id = id;
		this.description = description;
	}

	public Long getId() {
		return id;
	}


	public String getDescription() {
		return description;
	}

}
