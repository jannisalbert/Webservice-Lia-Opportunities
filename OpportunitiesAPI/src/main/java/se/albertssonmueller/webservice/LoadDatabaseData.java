package se.albertssonmueller.webservice;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.albertssonmueller.webservice.entities.Opportunity;
import se.albertssonmueller.webservice.repositories.OpportunityRepository;

import java.time.LocalDate;


@Configuration
public class LoadDatabaseData {


    @Bean
    CommandLineRunner loadDatabase(OpportunityRepository opportunityRepository) {
        return args -> {

            opportunityRepository.save(new Opportunity(1L, 1L,1L,1L,1L,"Good company",LocalDate.now(),"JaMu"));
            opportunityRepository.save(new Opportunity(2L, 2L,2L,2L,2L,"Good company",LocalDate.now(),"AlAn"));
            opportunityRepository.save(new Opportunity(3L, 3L,3L,3L,1L,"Good company",LocalDate.now(),"ALAn"));
            opportunityRepository.save(new Opportunity(4L, 4L,4L,4L,2L,"Good company",LocalDate.now(),"JaMu"));
            opportunityRepository.save(new Opportunity(5L, 5L,5L,5L,3L,"Good company",LocalDate.now(),"JamM"));

        };
    }
}
