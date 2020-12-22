package ua.realestate.management.dto;

import lombok.Data;

@Data
public class HistoryDTO {
    private Integer id;
    private Integer adminId;
    private Integer userId;
    private String before;
    private String after;
}
