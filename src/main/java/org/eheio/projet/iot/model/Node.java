package org.eheio.projet.iot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Float temperature;
    private Float humidity;
    private LocalDateTime dateTime;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }




}
