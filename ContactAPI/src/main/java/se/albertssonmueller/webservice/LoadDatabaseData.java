package se.albertssonmueller.webservice;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.albertssonmueller.webservice.entities.Contact;
import se.albertssonmueller.webservice.repositories.ContactRepository;


@Configuration
public class LoadDatabaseData {


    @Bean
    CommandLineRunner loadDatabase(ContactRepository contactRepository) {
        return args -> {

            contactRepository.save(new Contact(1L,1L,"Jannis","Müller","jannis@contactA.se", "0721068911"));
            contactRepository.save(new Contact(2L,2L,"Albert","Andersson","albert@contactB.se", "0722068922"));
            contactRepository.save(new Contact(3L,3L,"Rut","Pihl","rut@contactC.se", "0723068933"));
            contactRepository.save(new Contact(4L,4L,"Valter","Berggren","valter@contactD.se", "0724068944"));
            contactRepository.save(new Contact(5L,5L,"Gustav","Larsson","gustav@contactE.se", "0725068955"));


        };
    }
}
