package se.albertssonmueller.webservice.mappers;

import org.springframework.stereotype.Component;
import se.albertssonmueller.webservice.dtos.CompanyDto;
import se.albertssonmueller.webservice.entities.Company;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CompanyMapper {


    public CompanyMapper() {
    }

    public CompanyDto mapp(Company company) {
        return new CompanyDto(company.getId(), company.getName(), company.getWebsite(),
                company.getCity());
    }

    public Company mapp(CompanyDto companyDto) {
        return new Company(companyDto.getId(), companyDto.getName(), companyDto.getWebsite(), companyDto.getCity());
    }

    public Optional<CompanyDto> mapp(Optional<Company> optionalCompany) {
        if (optionalCompany.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalCompany.get()));
    }

    public List<CompanyDto> mapp(List<Company> all) {

        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}