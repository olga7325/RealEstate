package ua.realestate.management.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.realestate.management.dto.BuildingDTO;
import ua.realestate.management.entity.BuildingEntity;

@AllArgsConstructor
@Component
public class BuildingMapper implements Mapper<BuildingEntity, BuildingDTO>{
    private ModelMapper modelMapper;

    @Override
    public BuildingEntity toEntity(BuildingDTO dto) {
        return modelMapper.map(dto, BuildingEntity.class);
    }

    @Override
    public BuildingDTO toDto(BuildingEntity entity) {
        return modelMapper.map(entity, BuildingDTO.class);
    }
}
