package ua.realestate.management.service;

import ua.realestate.management.entity.Building;
import ua.realestate.management.repository.BuildingRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuildingService {
    private BuildingRepo buildingRepo;

    public Building create (Building building){
        return buildingRepo.save(building);
    }

    public Building findByBuilderCompany(String builderCompany){
        return (Building) buildingRepo.findByBuilderCompany(builderCompany);
    }

//    public Building update (Building entity){
//        Building building = findByBuilderCompany(entity.getBuilderCompany());
//        building.setBuilderCompany(entity.getBuilderCompany());
//        building.setFloors(entity.getFloors());
//        building.setPrice(entity.getPrice());
//        return buildingRepo.save(building);
//    }

    public Integer delete(Integer id){
        buildingRepo.deleteById(id);
        return id;
    }
}