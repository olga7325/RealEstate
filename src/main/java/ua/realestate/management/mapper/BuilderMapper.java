package ua.realestate.management.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.realestate.management.dto.BuilderDTO;
import ua.realestate.management.entity.BuilderEntity;

@AllArgsConstructor
@Component
public class BuilderMapper implements Mapper<BuilderEntity, BuilderDTO>{
    private ModelMapper modelMapper;

    @Override
    public BuilderEntity toEntity(BuilderDTO dto) {
        return modelMapper.map(dto, BuilderEntity.class);
    }

    @Override
    public BuilderDTO toDto(BuilderEntity entity) {
        return modelMapper.map(entity, BuilderDTO.class);
    }
}
