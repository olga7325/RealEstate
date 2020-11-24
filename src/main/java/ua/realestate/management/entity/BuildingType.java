package ua.realestate.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "building_types")
public class BuildingType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String type;
    private String description;

}
