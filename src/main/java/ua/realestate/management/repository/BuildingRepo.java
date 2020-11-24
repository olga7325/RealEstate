package ua.realestate.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.realestate.management.entity.Building;

import java.util.List;

public interface BuildingRepo extends JpaRepository<Building, Integer> {
    List<Building> findByBuilderCompany(String builderCompany);
}
