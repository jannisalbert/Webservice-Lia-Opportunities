package se.mueller.webservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import se.mueller.webservice.dtos.CompanyDto;
import se.mueller.webservice.services.Service;

import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {

    private final Service service;

    public CompanyController(Service service) {
        this.service = service;
    }

    @GetMapping("/companies")
    public List<CompanyDto> all(Long id) {
        return service.getAllCompanies();
    }

    @GetMapping("/companies/{id}")
    public Optional <CompanyDto> getOne(@PathVariable Long id){

        return Optional.ofNullable(service.getOne(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id " + id + " not found.")));

    }

    @PostMapping("/companies")
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyDto create(@RequestBody CompanyDto companyDto) {
        return service.createCompany(companyDto);
    }


    @DeleteMapping("/companies/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/companies/{id}")
    public CompanyDto replace(@RequestBody CompanyDto directorDto, @PathVariable Long id) {
        return service.replace(id, directorDto);
    }

}






