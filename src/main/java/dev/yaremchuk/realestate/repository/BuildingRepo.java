package dev.yaremchuk.realestate.repository;

import dev.yaremchuk.realestate.entity.Building;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuildingRepo extends CrudRepository<Building, Integer> {
    List<Building> findByBuilderCompany(String builderCompany);
}
