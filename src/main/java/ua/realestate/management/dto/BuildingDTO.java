package ua.realestate.management.dto;

import lombok.Data;
import ua.realestate.management.entity.BuildingState;
import ua.realestate.management.entity.BuildingType;

import java.util.Date;

@Data
public class BuildingDTO {
    private Integer id;
    private int floors;
    private int price;
    private Date buildingStarted;
    private Date buildingCompleted;
    private Date putIntoOperation;
    private BuildingType buildingType;
    private BuildingState buildingState;
}
