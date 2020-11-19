package dev.yaremchuk.realestate.controller;

import dev.yaremchuk.realestate.entity.Building;
import dev.yaremchuk.realestate.entity.User;
import dev.yaremchuk.realestate.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@AllArgsConstructor
@Controller
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    @GetMapping
    public String users(Map<String, Object> model){
        Iterable<User> users = userRepository.findAll();

        model.put("users", users);

        return "user";
    }
}
