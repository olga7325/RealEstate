package ua.realestate.management.service;

import ua.realestate.management.entity.*;
import ua.realestate.management.repository.BuildingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;
    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public Building create (Building building){
        return buildingRepository.save(building);
    }

    public Building findOne(Integer id){
        return buildingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Building not found")));
    }

    public List<Building> findAll(){
        return (List<Building>) buildingRepository.findAll();
    }

    public List<Building> findByBuildingType(BuildingType buildingType){
        return (List<Building>) buildingRepository.findByBuildingType(buildingType);
    }

    public List<Building> findByFloors(Integer floors){
        return (List<Building>) buildingRepository.findByFloors(floors);
    }

    public List<Building> findByBuildingState(BuildingState buildingState){
        return (List<Building>) buildingRepository.findByBuildingState(buildingState);
    }

    public Building update (Building entity){
        Building building = findOne(entity.getId());
        building.setBuildingState(entity.getBuildingState());
        building.setFloors(entity.getFloors());
        building.setBuildingType(entity.getBuildingType());
        building.setPrice(entity.getPrice());
        building.setBuildingStarted(entity.getBuildingStarted());
        building.setBuildingCompleted(entity.getBuildingCompleted());
        building.setPutIntoOperation(entity.getPutIntoOperation());
        return buildingRepository.save(building);
    }

    public Integer delete(Integer id){
        buildingRepository.deleteById(id);
        return id;
    }
}
