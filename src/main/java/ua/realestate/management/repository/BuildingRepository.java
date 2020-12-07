package ua.realestate.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.realestate.management.entity.BuildingEntity;
import ua.realestate.management.entity.BuildingState;
import ua.realestate.management.entity.BuildingType;

import java.util.List;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Integer> {
    List<BuildingEntity> findByBuildingType(BuildingType buildingType);
    List<BuildingEntity> findByFloors(Integer floors);
    List<BuildingEntity> findByBuildingState(BuildingState buildingState);
}
