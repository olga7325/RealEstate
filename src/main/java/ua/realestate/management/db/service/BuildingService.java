package ua.realestate.management.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import ua.realestate.management.entity.*;
import ua.realestate.management.exception.ErrorMessage;
import ua.realestate.management.exception.exceptions.NotDeletedException;
import ua.realestate.management.repository.BuildingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public BuildingEntity create (BuildingEntity buildingEntity){
        return buildingRepository.save(buildingEntity);
    }

    public BuildingEntity findOne(Integer id){
        return buildingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Building  with id " + id + "does not exist")));
    }

    public List<BuildingEntity> findAll(){
        return (List<BuildingEntity>) buildingRepository.findAll();
    }

    public List<BuildingEntity> findByBuildingType(BuildingType buildingType){
        return (List<BuildingEntity>) buildingRepository.findByBuildingType(buildingType);
    }

    public List<BuildingEntity> findByFloors(Integer floors){
        return (List<BuildingEntity>) buildingRepository.findByFloors(floors);
    }

    public List<BuildingEntity> findByBuildingState(BuildingState buildingState){
        return (List<BuildingEntity>) buildingRepository.findByBuildingState(buildingState);
    }

    public BuildingEntity update (BuildingEntity entity){
        BuildingEntity buildingEntity = findOne(entity.getId());
        buildingEntity.setBuildingState(entity.getBuildingState());
        buildingEntity.setFloors(entity.getFloors());
        buildingEntity.setBuildingType(entity.getBuildingType());
        buildingEntity.setPrice(entity.getPrice());
        buildingEntity.setBuildingStarted(entity.getBuildingStarted());
        buildingEntity.setBuildingCompleted(entity.getBuildingCompleted());
        buildingEntity.setPutIntoOperation(entity.getPutIntoOperation());
        return buildingRepository.save(buildingEntity);
    }

    public Integer delete(Integer id){
        if(!buildingRepository.findById(id).isPresent()){
            throw new NotDeletedException(ErrorMessage.BUILDING_NOT_DELETED);
        }
        buildingRepository.deleteById(id);
        return id;
    }
}
