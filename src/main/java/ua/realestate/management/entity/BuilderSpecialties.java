package ua.realestate.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "builder_specialties")
public class BuilderSpecialties {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String specialty;
    private String description;
}
