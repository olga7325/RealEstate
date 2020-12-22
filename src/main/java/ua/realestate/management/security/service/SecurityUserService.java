package ua.realestate.management.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.realestate.management.entity.UserEntity;
import ua.realestate.management.repository.UserRepository;
import ua.realestate.management.security.entity.SecurityUserEntity;

import javax.transaction.Transactional;

import static ua.realestate.management.exception.ErrorMessage.USER_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class SecurityUserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);

        return SecurityUserEntity.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Integer id){
        UserEntity user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_BY_ID, id)));

        return SecurityUserEntity.create(user);
    }
}
