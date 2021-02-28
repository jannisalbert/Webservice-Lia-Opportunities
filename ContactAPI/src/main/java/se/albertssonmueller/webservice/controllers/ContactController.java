package se.albertssonmueller.webservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import se.albertssonmueller.webservice.dtos.ContactDto;
import se.albertssonmueller.webservice.services.Service;

import java.util.List;
import java.util.Optional;

@RestController
public class ContactController {

    private final Service service;

    public ContactController(Service service) {
        this.service = service;
    }

    @GetMapping("/contacts")
    public List<ContactDto> all() {
        return service.getAllContacts();
    }

    @GetMapping("/contacts/{id}")
    public Optional <ContactDto> getOne(@PathVariable Long id){

        return Optional.ofNullable(service.getOne(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id " + id + " not found.")));

    }

    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDto create(@RequestBody ContactDto contactDto) {
        return service.createContact(contactDto);
    }


    @DeleteMapping("/contacts/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/contacts/{id}")
    public ContactDto replace(@RequestBody ContactDto directorDto, @PathVariable Long id) {
        return service.replace(id, directorDto);
    }

}






