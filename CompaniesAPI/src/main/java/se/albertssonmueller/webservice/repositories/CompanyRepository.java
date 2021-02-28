package se.albertssonmueller.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import se.albertssonmueller.webservice.dtos.CompanyDto;
import se.albertssonmueller.webservice.entities.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>, JpaSpecificationExecutor<CompanyDto> {


}
