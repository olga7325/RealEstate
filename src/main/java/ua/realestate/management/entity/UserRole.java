package ua.realestate.management.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String role;
    private String description;
}
