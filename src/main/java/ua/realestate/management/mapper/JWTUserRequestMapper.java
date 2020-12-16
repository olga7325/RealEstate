package ua.realestate.management.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.realestate.management.entity.UserEntity;
import ua.realestate.management.security.JWTUserRequest;

@AllArgsConstructor
@Component
public class JWTUserRequestMapper implements Mapper<UserEntity, JWTUserRequest>{
    private ModelMapper modelMapper;

    @Override
    public UserEntity toEntity(JWTUserRequest dto) {
        return modelMapper.map(dto, UserEntity.class);
    }

    @Override
    public JWTUserRequest toDto(UserEntity entity) {
        return modelMapper.map(entity, JWTUserRequest.class);
    }
}
