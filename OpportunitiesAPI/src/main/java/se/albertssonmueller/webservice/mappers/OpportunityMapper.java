package se.albertssonmueller.webservice.mappers;

import org.springframework.stereotype.Component;
import se.albertssonmueller.webservice.dtos.OpportunityDto;
import se.albertssonmueller.webservice.entities.Opportunity;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Component
public class OpportunityMapper {


    public OpportunityMapper() {
    }

    public OpportunityDto mapp(Opportunity opportunity) {
        return new OpportunityDto(opportunity.getId(), opportunity.getCompanyId(), opportunity.getContactId(),
                opportunity.getStatusId(), opportunity.getPriorityId(), opportunity.getComment(), opportunity.getDateCreated(),opportunity.getRegSign());

    }
    public Opportunity mapp(OpportunityDto opportunityDto) {
        return new Opportunity(opportunityDto.getId(), opportunityDto.getCompanyId(), opportunityDto.getContactId(),
                opportunityDto.getStatusId(), opportunityDto.getPriorityId(), opportunityDto.getComment(), opportunityDto.getDateCreated(),opportunityDto.getRegSign());

    }



    public Optional<OpportunityDto> mapp(Optional<Opportunity> optionalOpportunity) {
        if (optionalOpportunity.get().getCompanyId().equals(null))
            return Optional.empty();
        return Optional.of(mapp(optionalOpportunity.get()));
    }

    public List<OpportunityDto> mapp(List<Opportunity> all) {

        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}