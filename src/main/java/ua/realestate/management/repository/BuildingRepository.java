package ua.realestate.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.realestate.management.entity.Building;
import ua.realestate.management.entity.BuildingState;
import ua.realestate.management.entity.BuildingType;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
    List<Building> findByBuildingType(BuildingType buildingType);
    List<Building> findByFloors(Integer floors);
    List<Building> findByBuildingState(BuildingState buildingState);
}
