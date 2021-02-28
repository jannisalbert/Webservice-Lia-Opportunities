package se.albertssonmueller.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import se.albertssonmueller.webservice.dtos.ContactDto;
import se.albertssonmueller.webservice.entities.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>, JpaSpecificationExecutor<ContactDto> {


}
