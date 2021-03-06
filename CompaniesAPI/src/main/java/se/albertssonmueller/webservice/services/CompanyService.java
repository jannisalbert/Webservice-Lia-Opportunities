package se.albertssonmueller.webservice.services;
import se.albertssonmueller.webservice.dtos.CompanyDto;
import se.albertssonmueller.webservice.entities.Company;
import se.albertssonmueller.webservice.mappers.CompanyMapper;
import se.albertssonmueller.webservice.repositories.CompanyRepository;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements se.albertssonmueller.webservice.services.Service {

    private final CompanyRepository companyRepository;
    private CompanyMapper companyMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public List<CompanyDto> getAllCompanies() {

    return companyMapper.mapp(companyRepository.findAll());
    }

    @Override
    public Optional<CompanyDto> getOne(Long id) {
        return companyMapper.mapp(companyRepository.findById(id));
    }

    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {
        if (companyDto.getName().isEmpty())
            throw new RuntimeException();
        return companyMapper.mapp(companyRepository.save(companyMapper.mapp(companyDto)));
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);

    }

    @Override
    public CompanyDto replace(Long id, CompanyDto companyDto) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {

            Company updatedCompany = company.get();
            updatedCompany.setName(companyDto.getName());
            updatedCompany.setWebsite(companyDto.getWebsite());
            updatedCompany.setCity(companyDto.getCity());

            return companyMapper.mapp(companyRepository.save(updatedCompany));

        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Id " + id + " not found.");
    }


}





