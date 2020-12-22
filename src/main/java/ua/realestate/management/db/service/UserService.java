package ua.realestate.management.db.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.realestate.management.entity.UserEntity;
import ua.realestate.management.exception.exceptions.BadEmailException;
import ua.realestate.management.exception.exceptions.UserAlreadyRegisteredException;
import ua.realestate.management.mapper.UserRegistrationRequestMapper;
import ua.realestate.management.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.realestate.management.security.JWTSuccessLogIn;
import ua.realestate.management.security.JWTUserRequest;
import ua.realestate.management.security.JwtTokenProvider;
import ua.realestate.management.security.UserRegistrationRequest;

import java.util.List;
import java.util.Optional;

import static ua.realestate.management.exception.ErrorMessage.*;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRegistrationRequestMapper userRegistrationRequestMapper;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public UserEntity save(UserRegistrationRequest userRequest){
        if(userRepository.existsByEmail(userRequest.getEmail())){
            throw new UserAlreadyRegisteredException(String.format(USER_ALREADY_EXISTS, userRequest.getEmail()));
        }
        UserEntity user = userRegistrationRequestMapper.toEntity(userRequest);
        userRepository.save(user);
        return user;
    }

    public void save(UserEntity user){userRepository.save(user); }

    public JWTSuccessLogIn login(JWTUserRequest loginRequest, Authentication authentication){
        UserEntity user = userRepository.findByEmail(loginRequest.getEmail());
        return new JWTSuccessLogIn(user.getId(), jwtTokenProvider.generateAccessToken(authentication), jwtTokenProvider.generateRefreshToken(authentication), user.getName());
    }

    public void changeUserPassword(Integer userId, String password){
        UserEntity user = userRepository.findById(userId).orElseThrow(
                () -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_BY_ID, userId)));
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    public boolean checkIfValidOldPassword(String newPassword, String oldPassword){
        return passwordEncoder.matches(oldPassword, newPassword);
    }

    public UserEntity findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public UserEntity findById(Integer id){
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_BY_ID, id)));
    }

}
