package se.albertssonmueller.webservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import se.albertssonmueller.webservice.dtos.CompanyDto;
import se.albertssonmueller.webservice.services.Service;

import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {

    private final Service service;

    public CompanyController(Service service) {
        this.service = service;
    }

    @GetMapping("/contacts")
    public List<CompanyDto> all(Long id) {
        return service.getAllCompanies();
    }

    @GetMapping("/contacts/{id}")
    public Optional <CompanyDto> getOne(@PathVariable Long id){

        return Optional.ofNullable(service.getOne(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id " + id + " not found.")));

    }

    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyDto create(@RequestBody CompanyDto companyDto) {
        return service.createCompany(companyDto);
    }


    @DeleteMapping("/contacts/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/contacts/{id}")
    public CompanyDto replace(@RequestBody CompanyDto directorDto, @PathVariable Long id) {
        return service.replace(id, directorDto);
    }

}






