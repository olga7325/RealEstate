package dev.yaremchuk.realestate.controller;

import dev.yaremchuk.realestate.entity.Builder;
import dev.yaremchuk.realestate.repository.BuilderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@AllArgsConstructor
@Controller
@CrossOrigin
@RequestMapping("builders")
public class BuilderController {

    private BuilderRepository builderRepository;

    @GetMapping
    public String builders(Map<String, Object> model){
        Iterable<Builder> builders = builderRepository.findAll();

        model.put("builders", builders);

        return "builder";
    }
}
