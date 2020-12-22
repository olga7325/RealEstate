package ua.realestate.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ua.realestate.management.db.service.UserService;
import ua.realestate.management.entity.UserEntity;
import ua.realestate.management.mapper.JWTUserRequestMapper;
import ua.realestate.management.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import ua.realestate.management.security.JWTSuccessLogIn;
import ua.realestate.management.security.JWTUserRequest;
import ua.realestate.management.security.UserRegistrationRequest;

import javax.validation.Valid;
import java.util.Map;

@AllArgsConstructor
@Controller
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private final UserService userService;
    private final JWTUserRequestMapper modelMapper;
    private final AuthenticationManager authenticationManager;

    @GetMapping
    public String users(Map<String, Object> model){
        Iterable<UserEntity> users = userRepository.findAll();

        model.put("users", users);

        return "user";
    }

    @PostMapping("login")
    public ResponseEntity<JWTSuccessLogIn> authenticateUser(@Valid @RequestBody JWTUserRequest logInRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        logInRequest.getEmail(),
                        logInRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok(userService.login(logInRequest, authentication));
    }

    @PostMapping("/register")
    public ResponseEntity<JWTUserRequest> signUp(@RequestBody UserRegistrationRequest userRequest){
        UserEntity user = userService.save(userRequest);
        return ResponseEntity.ok().body(modelMapper.toDto(user));
    }

//    @GetMapping("/registration")
//    public String registration(){
//        return "registration";
//    }
//    @PostMapping("/registration")
//    public String addUser(UserEntity userEntity, Map<String, Object> model){
//        UserEntity userEntityFromDB = userRepository.findByName(userEntity.getName());
//
//        if(userEntityFromDB != null){
//            model.put("message", "User exists!");
//            return "registration";
//        }
//
//        //user.setRoles(Collections.singleton(Role.BASIC_USER));
//        userRepository.save(userEntity);
//
//        return "redirect:/login";
//    }
}
