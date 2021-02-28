package se.albertssonmueller.webservice.mappers;

import org.springframework.stereotype.Component;
import se.albertssonmueller.webservice.dtos.StatusDto;
import se.albertssonmueller.webservice.entities.Status;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StatusMapper {


	public StatusMapper() {
	}

	public Status mapp(StatusDto statusDto) {
		return new Status(statusDto.getId(), statusDto.getDescription());
	}

	public Optional<StatusDto> mapp(Optional<Status> optionalStatus) {
		if (optionalStatus.isEmpty())
			return Optional.empty();
		return Optional.of(mapp(optionalStatus.get()));
	}

	public StatusDto mapp(Status status) {
		return new StatusDto(status.getId(), status.getDescription());
	}

	public List<StatusDto> mapp(List<Status> all) {

		return all
				.stream()
				.map(this :: mapp)
				.collect(Collectors.toList());
	}
}