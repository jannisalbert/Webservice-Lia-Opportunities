package se.albertssonmueller.webservice.services;


import se.albertssonmueller.webservice.dtos.ContactDto;

import java.util.List;
import java.util.Optional;

public interface Service {

    List<ContactDto> getAllContacts();

    Optional<ContactDto> getOne(Long id);

    ContactDto createContact(ContactDto directorDto);

    void delete(Long id);

    ContactDto replace(Long id, ContactDto directorDto);

}

