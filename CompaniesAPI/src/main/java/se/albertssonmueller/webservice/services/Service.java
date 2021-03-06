package se.albertssonmueller.webservice.services;


import se.albertssonmueller.webservice.dtos.CompanyDto;

import java.util.List;
import java.util.Optional;

public interface Service {

    List<CompanyDto> getAllCompanies();

    Optional<CompanyDto> getOne(Long id);

    CompanyDto createCompany(CompanyDto directorDto);

    void delete(Long id);

    CompanyDto replace(Long id, CompanyDto directorDto);

}

