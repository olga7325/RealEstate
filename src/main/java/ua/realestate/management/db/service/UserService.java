package ua.realestate.management.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.realestate.management.entity.UserEntity;
import ua.realestate.management.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void create(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public Optional<UserEntity> findByEmail(String email){
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    public UserEntity findByName(String name){
        return userRepository.findByName(name);
    }

    public Optional<UserEntity> findById(Integer id){
        return userRepository.findById(id);
    }

    public List<UserEntity> findAll(){
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByName(name);
    }
}
