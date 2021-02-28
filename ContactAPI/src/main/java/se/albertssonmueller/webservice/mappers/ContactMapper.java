package se.albertssonmueller.webservice.mappers;

import org.springframework.stereotype.Component;
import se.albertssonmueller.webservice.dtos.ContactDto;
import se.albertssonmueller.webservice.entities.Contact;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ContactMapper {


    public ContactMapper() {
    }

    public ContactDto mapp(Contact contact) {
        return new ContactDto(contact.getId(), contact.getCompanyId(), contact.getFirstName(),
                contact.getLastName(), contact.getEmail(), contact.getPhone());
    }

    public Contact mapp(ContactDto contactDto) {
        return new Contact(contactDto.getId(), contactDto.getCompanyId(), contactDto.getFirstName(),
                contactDto.getLastName(), contactDto.getEmail(), contactDto.getPhone());
    }

    public Optional<ContactDto> mapp(Optional<Contact> optionalContact) {
        if (optionalContact.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalContact.get()));
    }

    public List<ContactDto> mapp(List<Contact> all) {

        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}