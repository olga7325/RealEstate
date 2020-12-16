package ua.realestate.management.mapper;

import lombok.AllArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ua.realestate.management.entity.UserEntity;
import ua.realestate.management.security.UserRegistrationRequest;

import org.modelmapper.ModelMapper;


@Component
@AllArgsConstructor
public class UserRegistrationRequestMapper implements Mapper <UserEntity, UserRegistrationRequest> {
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserEntity toEntity(UserRegistrationRequest dto) {
        UserEntity userEntity = modelMapper.map(dto, UserEntity.class);
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        userEntity.setIsActive(true);
        return userEntity;
    }

    @Override
    public UserRegistrationRequest toDto(UserEntity entity) {
        return modelMapper.map(entity, UserRegistrationRequest.class);
    }
}
