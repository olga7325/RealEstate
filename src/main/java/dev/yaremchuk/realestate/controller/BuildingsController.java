package dev.yaremchuk.realestate.controller;
import dev.yaremchuk.realestate.entity.Building;
import dev.yaremchuk.realestate.repository.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/buildings")
public class BuildingsController {

    @Autowired
    private BuildingRepo buildingRepo;

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<Building> buildings = buildingRepo.findAll();

        model.put("buildings", buildings);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text,@RequestParam int floors, @RequestParam int progress, @RequestParam int price, Map<String, Object> model){
        Building building = new Building(text, floors, progress, price);

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
