package ua.realestate.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ua.realestate.management.entity.MachineryEntity;
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

    @Autowired
    private MachineryRepository machineryRepository;

    @GetMapping
    public String machinery(Map<String, Object> model){
        Iterable<MachineryEntity> machinery = machineryRepository.findAll();

        model.put("machinery", machinery);

        return "machinery";
    }
}
