package se.mueller.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import se.mueller.webservice.dtos.CompanyDto;
import se.mueller.webservice.entities.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>, JpaSpecificationExecutor<CompanyDto> {


}
