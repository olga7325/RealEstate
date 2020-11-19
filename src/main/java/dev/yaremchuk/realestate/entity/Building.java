package dev.yaremchuk.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class Building {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String builderCompany;
    private int floors;
    private int progress;
    private int price;

    public Building() { }

    public Building(String builderCompany, int floors, int progress, int price) {
        this.builderCompany = builderCompany;
        this.floors = floors;
        this.progress = progress;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuilderCompany() {
        return builderCompany;
    }

    public void setBuilderCompany(String builderCompany) {
        this.builderCompany = builderCompany;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
