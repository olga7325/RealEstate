package ua.realestate.management.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "building_state")
public class BuildingState {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String state;
    private String description;
}
