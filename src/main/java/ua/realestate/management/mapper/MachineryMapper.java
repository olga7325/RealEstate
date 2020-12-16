package ua.realestate.management.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.realestate.management.dto.MachineryDTO;
import ua.realestate.management.entity.MachineryEntity;

@AllArgsConstructor
@Component
public class MachineryMapper implements Mapper<MachineryEntity, MachineryDTO>{
    private ModelMapper modelMapper;

    @Override
    public MachineryEntity toEntity(MachineryDTO dto) {
        return modelMapper.map(dto, MachineryEntity.class);
    }

    @Override
    public MachineryDTO toDto(MachineryEntity entity) {
        return modelMapper.map(entity, MachineryDTO.class);
    }
}
