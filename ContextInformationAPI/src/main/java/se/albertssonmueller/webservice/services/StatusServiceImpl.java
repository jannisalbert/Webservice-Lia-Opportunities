package se.albertssonmueller.webservice.services;

import org.springframework.stereotype.Service;
import se.albertssonmueller.webservice.dtos.StatusDto;
import se.albertssonmueller.webservice.mappers.StatusMapper;
import se.albertssonmueller.webservice.repositories.StatusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {

	private final StatusRepository statusRepository;
	private final StatusMapper statusMapper;

	public StatusServiceImpl(StatusRepository statusRepository, StatusMapper statusMapper) {
		this.statusRepository = statusRepository;
		this.statusMapper = statusMapper;
	}

	@Override
	public List<StatusDto> getAllStatus() {

		return statusMapper.mapp(statusRepository.findAll());
	}

	@Override
	public Optional<StatusDto> getOneStatus(Long id) {
		return statusMapper.mapp(statusRepository.findById(id));
	}
}





