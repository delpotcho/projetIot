package org.eheio.projet.iot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Environment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ID;
    private String name ;
    @ManyToMany
    private List<Category> categories;
    //@OneToMany (mappedBy = "envirenment")
    //private List<Node> nodes ;
    private double minHumidity;
    private double maxHumidity;
    private double minTemperature;
    private double maxTemperature;

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinHumidity() {
        return minHumidity;
    }

    public void setMinHumidity(double minHumidity) {
        this.minHumidity = minHumidity;
    }

    public double getMaxHumidity() {
        return maxHumidity;
    }

    public void setMaxHumidity(double maxHumidity) {
        this.maxHumidity = maxHumidity;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
}
