package se.albertssonmueller.webservice;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.albertssonmueller.webservice.entities.Status;
import se.albertssonmueller.webservice.repositories.StatusRepository;


@Configuration
public class LoadDatabaseData {


	@Bean
	CommandLineRunner loadDatabase(StatusRepository statusRepository) {
		return args -> {

			statusRepository.save(new Status(1L, "Not contacted"));
			statusRepository.save(new Status(2L, "Email sent"));
			statusRepository.save(new Status(3L, "Follow up"));
			statusRepository.save(new Status(4L, "Interview"));
			statusRepository.save(new Status(5L, "Dead"));

		};
	}
}
