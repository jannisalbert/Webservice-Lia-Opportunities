package se.albertssonmueller.webservice;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.albertssonmueller.webservice.entities.Priority;
import se.albertssonmueller.webservice.entities.Status;
import se.albertssonmueller.webservice.repositories.PriorityRepository;
import se.albertssonmueller.webservice.repositories.StatusRepository;


@Configuration
public class LoadDatabase {


	@Bean
	CommandLineRunner loadDatabaseData(StatusRepository statusRepository, PriorityRepository priorityRepository) {
		return args -> {

			statusRepository.save(new Status(1L, "Not contacted"));
			statusRepository.save(new Status(2L, "Email sent"));
			statusRepository.save(new Status(3L, "Follow up"));
			statusRepository.save(new Status(4L, "Interview"));
			statusRepository.save(new Status(5L, "Dead"));

			priorityRepository.save(new Priority(1L, "A"));
			priorityRepository.save(new Priority(2L, "B"));
			priorityRepository.save(new Priority(3L, "C"));

		};
	}

}