package ua.realestate.management.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "builders")

//@javax.persistence.Cacheable
//@org.hibernate.annotations.Cache(region = "builderCache", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BuilderEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialty")
    @NonNull
    private BuilderSpecialties builderSpecialties;

}
