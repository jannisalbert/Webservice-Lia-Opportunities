package se.albertssonmueller.webservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import se.albertssonmueller.webservice.dtos.OpportunityDto;
import se.albertssonmueller.webservice.services.Service;

import java.util.List;
import java.util.Optional;

@RestController
public class OpportunityController {

    private final Service service;

    public OpportunityController(Service service) {
        this.service = service;
    }

    @GetMapping("/opportunities")
    public List<OpportunityDto> all(Long id) {
        return service.getAllOpportunities();
    }

    @GetMapping("/opportunities/{id}")
    public Optional <OpportunityDto> getOne(@PathVariable Long id){

        return Optional.ofNullable(service.getOne(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id " + id + " not found.")));
    }

    @PostMapping("/opportunities")
    @ResponseStatus(HttpStatus.CREATED)
    public OpportunityDto create(@RequestBody OpportunityDto opportunityDto) {
        return service.createOpportunity(opportunityDto);
    }

    @DeleteMapping("/opportunities/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/opportunities/{id}")
    public OpportunityDto replace(@RequestBody OpportunityDto directorDto, @PathVariable Long id) {
        return service.replace(id, directorDto);
    }

}






