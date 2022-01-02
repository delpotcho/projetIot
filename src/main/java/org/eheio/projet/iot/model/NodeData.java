package org.eheio.projet.iot.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class NodeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double temperature;
    private double humidity;
    private LocalDateTime dateTime;
    @ManyToOne
    private Node node;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
