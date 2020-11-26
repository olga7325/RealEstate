package ua.realestate.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "builders")
public class Builder {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialty")
    @NonNull
    private BuilderSpecialties builderSpecialties;

}
