package dev.yaremchuk.realestate.service;

import dev.yaremchuk.realestate.entity.Machinery;
import dev.yaremchuk.realestate.entity.User;
import dev.yaremchuk.realestate.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;

    public void create(User user){
        userRepository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }

    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }
}
