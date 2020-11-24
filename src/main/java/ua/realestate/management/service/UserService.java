package ua.realestate.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.realestate.management.entity.User;
import ua.realestate.management.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

//    private final UserRepository userRepository;
//    public UserService(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }

    public void create(User user){
        userRepository.save(user);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User findByName(String name){
        return userRepository.findByName(name);
    }

    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }

    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByName(name);
    }
}
