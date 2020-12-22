package ua.realestate.management.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.realestate.management.dto.BuildingStateDTO;
import ua.realestate.management.entity.BuildingState;

@AllArgsConstructor
@Component
public class BuildingStateMapper implements Mapper<BuildingState, BuildingStateDTO>{
    private ModelMapper modelMapper;

    @Override
    public BuildingState toEntity(BuildingStateDTO dto) {
        return modelMapper.map(dto, BuildingState.class);
    }

    @Override
    public BuildingStateDTO toDto(BuildingState entity) {
        return modelMapper.map(entity, BuildingStateDTO.class);
    }
}
