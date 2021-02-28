package se.albertssonmueller.webservice.services;
import se.albertssonmueller.webservice.dtos.OpportunityDto;
import se.albertssonmueller.webservice.entities.Opportunity;
import se.albertssonmueller.webservice.mappers.OpportunityMapper;
import se.albertssonmueller.webservice.repositories.OpportunityRepository;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OpportunityService implements se.albertssonmueller.webservice.services.Service {

    private final OpportunityRepository opportunityRepository;
    private OpportunityMapper opportunityMapper;

    public OpportunityService(OpportunityRepository opportunityRepository, OpportunityMapper opportunityMapper) {
        this.opportunityRepository = opportunityRepository;
        this.opportunityMapper = opportunityMapper;
    }

    @Override
    public List<OpportunityDto> getAllOpportunities() {

    return opportunityMapper.mapp(opportunityRepository.findAll());
    }

    @Override
    public Optional<OpportunityDto> getOne(Long id) {
        return opportunityMapper.mapp(opportunityRepository.findById(id));
    }

    @Override
    public OpportunityDto createOpportunity(OpportunityDto opportunityDto) {
        if (opportunityDto.getCompanyId() == null)
            throw new RuntimeException();
        return opportunityMapper.mapp(opportunityRepository.save(opportunityMapper.mapp(opportunityDto)));
    }

    @Override
    public void delete(Long id) {
        opportunityRepository.deleteById(id);

    }

    @Override
    public OpportunityDto replace(Long id, OpportunityDto opportunityDto) {
        Optional<Opportunity> company = opportunityRepository.findById(id);
        if (company.isPresent()) {

            Opportunity updatedOpportunity = company.get();
            updatedOpportunity.setCompanyId(opportunityDto.getCompanyId());
            updatedOpportunity.setContactId(opportunityDto.getContactId());
            updatedOpportunity.setStatusId(opportunityDto.getStatusId());
            updatedOpportunity.setComment(opportunityDto.getComment());
            updatedOpportunity.setPriorityId(opportunityDto.getPriorityId());
            updatedOpportunity.setDateCreated(opportunityDto.getDateCreated());
            updatedOpportunity.setRegSign(opportunityDto.getRegSign());


            return opportunityMapper.mapp(opportunityRepository.save(updatedOpportunity));

        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Id " + id + " not found.");
    }


}





