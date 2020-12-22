package ua.realestate.management.dto;

import lombok.Data;
import ua.realestate.management.entity.BuilderSpecialties;

@Data
public class BuilderDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private BuilderSpecialties builderSpecialties;
}
