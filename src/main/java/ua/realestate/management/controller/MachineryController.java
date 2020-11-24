package ua.realestate.management.controller;

import ua.realestate.management.entity.Machinery;
import ua.realestate.management.repository.MachineryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@AllArgsConstructor
@Controller
@CrossOrigin
@RequestMapping("machinery")
public class MachineryController {

    private MachineryRepository machineryRepository;

    @GetMapping
    public String machinery(Map<String, Object> model){
        Iterable<Machinery> machinery = machineryRepository.findAll();

        model.put("machinery", machinery);

        return "machinery";
    }
}