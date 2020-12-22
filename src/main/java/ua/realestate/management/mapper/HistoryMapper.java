package ua.realestate.management.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.realestate.management.dto.HistoryDTO;
import ua.realestate.management.entity.HistoryEntity;

@AllArgsConstructor
@Component
public class HistoryMapper implements Mapper<HistoryEntity, HistoryDTO> {
    private ModelMapper modelMapper;

    @Override
    public HistoryEntity toEntity(HistoryDTO dto) {
        return modelMapper.map(dto, HistoryEntity.class);
    }

    @Override
    public HistoryDTO toDto(HistoryEntity entity) {
        return modelMapper.map(entity, HistoryDTO.class);
    }
}
