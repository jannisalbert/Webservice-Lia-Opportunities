package se.albertssonmueller.webservice.services;

import org.springframework.stereotype.Service;
import se.albertssonmueller.webservice.dtos.PriorityDto;
import se.albertssonmueller.webservice.mappers.PriorityMapper;
import se.albertssonmueller.webservice.repositories.PriorityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PriorityServiceImpl implements PriorityService{

	private final PriorityRepository priorityRepository;
	private final PriorityMapper priorityMapper;

	public PriorityServiceImpl(PriorityRepository priorityRepository, PriorityMapper priorityMapper) {
		this.priorityRepository = priorityRepository;
		this.priorityMapper = priorityMapper;
	}

	@Override
	public List<PriorityDto> getAllPriorities() {

		return priorityMapper.mapp(priorityRepository.findAll());
	}

	@Override
	public Optional<PriorityDto> getOnePriority(Long id) {
		return priorityMapper.mapp(priorityRepository.findById(id));
	}

}
