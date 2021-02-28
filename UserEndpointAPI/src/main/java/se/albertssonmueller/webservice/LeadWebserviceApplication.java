package se.albertssonmueller.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeadWebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeadWebserviceApplication.class, args);
    }


//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//        return args -> {
//            MovieDto quote = restTemplate.getForObject(
//                    "http://localhost:5054/movies/1", MovieDto.class);
//            System.out.println(quote);
//
//        };
//
//
//    }

}


