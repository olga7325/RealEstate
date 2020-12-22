package ua.realestate.management.controller;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import ua.realestate.management.db.service.BuildingService;
import ua.realestate.management.dto.BuildingDTO;
import ua.realestate.management.entity.BuilderEntity;
import ua.realestate.management.entity.BuildingEntity;
import ua.realestate.management.mapper.BuildingMapper;
import ua.realestate.management.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/buildings")
public class BuildingsController {

    @Autowired
    private BuildingRepository buildingRepository;

    private BuildingService buildingService;
    private BuildingMapper mapper;

    @ApiOperation(value = "Create new building ")
    @PostMapping
    public BuildingDTO create(@RequestBody BuildingDTO dto){
        BuildingEntity buildingEntity = mapper.toEntity(dto);
        BuildingEntity buildingCreated = buildingService.create(buildingEntity);
        return mapper.toDto(buildingCreated);
    }

    @ApiOperation(value = "List of all buildings ")
    @GetMapping
    public List<BuildingDTO> findAll(){
        List<BuildingEntity> allBuildings = buildingService.findAll();
        return allBuildings.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @ApiOperation(value = "Update building")
    @PutMapping
    public BuildingDTO update(@RequestBody BuildingDTO dto){
        BuildingEntity buildingEntity = mapper.toEntity(dto);
        BuildingEntity buildingUpdated = buildingService.update(buildingEntity);
        return mapper.toDto(buildingUpdated);
    }

    @ApiOperation(value = "Delete building by id ")
    @DeleteMapping
    public void delete(@RequestBody Integer id){
        buildingService.delete(id);
    }

//    @GetMapping("/")
//    public String greeting(Map<String, Object> model){
//        return "greeting";
//    }
//
//    @GetMapping("/main")
//    public String main(Map<String, Object> model){
//        Iterable<BuildingEntity> buildings = buildingRepository.findAll();
//
//        model.put("buildings", buildings);
//
//        return "main";
//    }
//
//    @PostMapping("/main")
//    public String add(
//            @AuthenticationPrincipal User user,
//            @RequestParam int floors,
//            @RequestParam int price, Map<String, Object> model){
//        BuildingEntity buildingEntity = new BuildingEntity(floors, price);
//
//        buildingRepository.save(buildingEntity);
//        Iterable<BuildingEntity> buildings = buildingRepository.findAll();
//        model.put("buildings", buildings);
//        return "main";
//    }

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
