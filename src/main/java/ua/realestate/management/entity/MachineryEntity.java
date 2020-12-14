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
@Table(name = "machinery")
public class MachineryEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String producer;
    private Integer quantity;
    private Date releaseDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type")
    @NonNull
    private MachineryType type;



}
