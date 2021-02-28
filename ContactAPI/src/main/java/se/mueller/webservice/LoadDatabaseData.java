package se.mueller.webservice;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.mueller.webservice.entities.Company;
import se.mueller.webservice.repositories.CompanyRepository;


@Configuration
public class LoadDatabaseData {


    @Bean
    CommandLineRunner loadDatabase(CompanyRepository companyRepository) {
        return args -> {

            companyRepository.save(new Company(1L,"Company A","companyA.se","Göteborg"));
            companyRepository.save(new Company(2L,"Company B","companyB.se","Göteborg"));
            companyRepository.save(new Company(3L,"Company C","companyC.se","Göteborg"));
            companyRepository.save(new Company(4L,"Company D","companyD.se","Göteborg"));
            companyRepository.save(new Company(5L,"Company E","companyE.se","Göteborg"));


        };
    }
}
