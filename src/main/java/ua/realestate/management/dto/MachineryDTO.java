package ua.realestate.management.dto;

import lombok.Data;
import ua.realestate.management.entity.MachineryType;

import java.util.Date;

@Data
public class MachineryDTO {
    private Integer id;
    private String producer;
    private Integer quantity;
    private Date releaseDate;
    private MachineryType type;
}
