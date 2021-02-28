package se.albertssonmueller.webservice.mappers;

import org.springframework.stereotype.Component;
import se.albertssonmueller.webservice.dtos.PriorityDto;
import se.albertssonmueller.webservice.entities.Priority;
import se.albertssonmueller.webservice.entities.Status;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PriorityMapper {


	public PriorityMapper() {
	}

	public Status mapp(PriorityDto priorityDto) {
		return new Status(priorityDto.getId(), priorityDto.getDescription());
	}

	public Optional<PriorityDto> mapp(Optional<Priority> optionalPriority) {
		if (optionalPriority.isEmpty())
			return Optional.empty();
		return Optional.of(mapp(optionalPriority.get()));
	}

	public PriorityDto mapp(Priority priority) {
		return new PriorityDto(priority.getId(), priority.getDescription());
	}

	public List<PriorityDto> mapp(List<Priority> all) {

		return all
				.stream()
				.map(this :: mapp)
				.collect(Collectors.toList());
	}
}