package ua.realestate.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "building_state")
public class BuildingState {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String state;
    private String description;
}
