package ua.realestate.management.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.realestate.management.dto.MachineryTypeDTO;
import ua.realestate.management.entity.MachineryType;

@AllArgsConstructor
@Component
public class MachineryTypeMapper implements Mapper<MachineryType, MachineryTypeDTO>{
    private ModelMapper modelMapper;

    @Override
    public MachineryType toEntity(MachineryTypeDTO dto) {
        return modelMapper.map(dto, MachineryType.class);
    }

    @Override
    public MachineryTypeDTO toDto(MachineryType entity) {
        return modelMapper.map(entity, MachineryTypeDTO.class);
    }
}
