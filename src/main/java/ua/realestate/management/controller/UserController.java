package ua.realestate.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import ua.realestate.management.entity.User;
import ua.realestate.management.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Map;

@AllArgsConstructor
@Controller
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String users(Map<String, Object> model){
        Iterable<User> users = userRepository.findAll();

        model.put("users", users);

        return "user";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDB = userRepository.findByName(user.getName());

        if(userFromDB != null){
            model.put("message", "User exists!");
            return "registration";
        }

        //user.setRoles(Collections.singleton(Role.BASIC_USER));
        userRepository.save(user);

        return "redirect:/login";
    }
}
