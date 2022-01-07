package org.eheio.projet.iot.dto.response;

import java.util.UUID;

public class ProductDto {
    private UUID id ;
    private String name ;
    private double maxTemperature;
    private double minTemperature;
    private double maxHumidity;
    private double minHumidity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxHumidity() {
        return maxHumidity;
    }

    public void setMaxHumidity(double maxHumidity) {
        this.maxHumidity = maxHumidity;
    }
    public double getMinHumidity() {
        return minHumidity;
    }
    public void setMinHumidity(double minHumidity) {
        this.minHumidity = minHumidity;
    }
}
