package se.albertssonmueller.webservice.services;
import se.albertssonmueller.webservice.dtos.ContactDto;
import se.albertssonmueller.webservice.entities.Contact;
import se.albertssonmueller.webservice.mappers.ContactMapper;
import se.albertssonmueller.webservice.repositories.ContactRepository;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements se.albertssonmueller.webservice.services.Service {

    private final ContactRepository contactRepository;
    private ContactMapper contactMapper;

    public ContactService(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    @Override
    public List<ContactDto> getAllContacts() {

    return contactMapper.mapp(contactRepository.findAll());
    }

    @Override
    public Optional<ContactDto> getOne(Long id) {
        return contactMapper.mapp(contactRepository.findById(id));
    }

    @Override
    public ContactDto createContact(ContactDto contactDto) {
        if (contactDto.getFirstName().isEmpty())
            throw new RuntimeException();
        return contactMapper.mapp(contactRepository.save(contactMapper.mapp(contactDto)));
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);

    }

    @Override
    public ContactDto replace(Long id, ContactDto contactDto) {
        Optional<Contact> company = contactRepository.findById(id);
        if (company.isPresent()) {

            Contact updatedContact = company.get();
            updatedContact.setFirstName(contactDto.getFirstName());
            updatedContact.setLastName(contactDto.getLastName());
            updatedContact.setEmail(contactDto.getEmail());
            updatedContact.setPhone(contactDto.getPhone());


            return contactMapper.mapp(contactRepository.save(updatedContact));

        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Id " + id + " not found.");
    }


}





