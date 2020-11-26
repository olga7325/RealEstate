package ua.realestate.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "buildings")
public class Building {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private int floors;
    private int price;
    private Date buildingStarted;
    private Date buildingCompleted;
    private Date putIntoOperation;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building_type")
    @NonNull
    private BuildingType buildingType;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building_state")
    @NonNull
    private BuildingState buildingState;


    public Building(int floors, int price) {
        this.floors = floors;
        this.price = price;
    }
}
