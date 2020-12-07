package ua.realestate.management.controller;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import ua.realestate.management.entity.BuildingEntity;
import ua.realestate.management.repository.BuildingRepository;
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
    private BuildingRepository buildingRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model){
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<BuildingEntity> buildings = buildingRepository.findAll();

        model.put("buildings", buildings);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam int floors,
            @RequestParam int price, Map<String, Object> model){
        BuildingEntity buildingEntity = new BuildingEntity(floors, price);

        buildingRepository.save(buildingEntity);
        Iterable<BuildingEntity> buildings = buildingRepository.findAll();
        model.put("buildings", buildings);
        return "main";
    }

//    @PostMapping("filter")
//    public String filter(@RequestParam String filter, Map<String, Object> model){
//        Iterable<Building> buildings;
//
//        if (filter != null && !filter.isEmpty()) {
//            buildings = buildingRepository.findByBuilderCompany(filter);
//        }else{
//            buildings = buildingRepository.findAll();
//        }
//        model.put("buildings", buildings);
//
//        return "main";
//    }
}
