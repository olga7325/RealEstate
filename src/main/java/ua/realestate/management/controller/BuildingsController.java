package ua.realestate.management.controller;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import ua.realestate.management.entity.Building;
import ua.realestate.management.repository.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/buildings")
public class BuildingsController {

    @Autowired
    private BuildingRepo buildingRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model){
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<Building> buildings = buildingRepo.findAll();

        model.put("buildings", buildings);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam int floors,
            @RequestParam int price, Map<String, Object> model){
        Building building = new Building(text, floors, price);

        buildingRepo.save(building);
        Iterable<Building> buildings = buildingRepo.findAll();
        model.put("buildings", buildings);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Building> buildings;

        if (filter != null && !filter.isEmpty()) {
            buildings = buildingRepo.findByBuilderCompany(filter);
        }else{
            buildings = buildingRepo.findAll();
        }
        model.put("buildings", buildings);

        return "main";
    }
}
