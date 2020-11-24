package ua.realestate.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "machinery_types")
public class MachineryType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String type;
    private String description;
}
