package ua.realestate.management.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.realestate.management.dto.BuilderSpecialtiesDTO;
import ua.realestate.management.entity.BuilderSpecialties;

@AllArgsConstructor
@Component
public class BuilderSpecialtiesMapper implements Mapper<BuilderSpecialties, BuilderSpecialtiesDTO> {
    private ModelMapper modelMapper;

    @Override
    public BuilderSpecialties toEntity(BuilderSpecialtiesDTO dto) {
        return modelMapper.map(dto, BuilderSpecialties.class);
    }

    @Override
    public BuilderSpecialtiesDTO toDto(BuilderSpecialties entity) {
        return modelMapper.map(entity, BuilderSpecialtiesDTO.class);
    }
}
