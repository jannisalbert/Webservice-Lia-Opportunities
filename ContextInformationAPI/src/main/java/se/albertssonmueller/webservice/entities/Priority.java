package se.albertssonmueller.webservice.entities;

import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;

@Entity
@Table(name ="priority")
public class Priority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;

	public Priority() {
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Priority(Long id, String description) {
		this.id = id;
		this.description = description;
	}
}
