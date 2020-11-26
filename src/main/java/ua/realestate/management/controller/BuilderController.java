package ua.realestate.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ua.realestate.management.entity.Builder;
import ua.realestate.management.repository.BuilderRepository;
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

    @Autowired
    private BuilderRepository builderRepository;

    @GetMapping
    public String builders(Map<String, Object> model){
        Iterable<Builder> builders = builderRepository.findAll();

        model.put("builders", builders);

        return "builder";
    }
}
