package ua.realestate.management.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.realestate.management.dto.BuildingTypeDTO;
import ua.realestate.management.entity.BuildingType;

@AllArgsConstructor
@Component
public class BuildingTypeMapper implements Mapper<BuildingType, BuildingTypeDTO>{
    private ModelMapper modelMapper;

    @Override
    public BuildingType toEntity(BuildingTypeDTO dto) {
        return modelMapper.map(dto, BuildingType.class);
    }

    @Override
    public BuildingTypeDTO toDto(BuildingType entity) {
        return modelMapper.map(entity, BuildingTypeDTO.class);
    }
}
