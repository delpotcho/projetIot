package org.eheio.projet.iot.dto.request;

import org.eheio.projet.iot.model.Node;
import org.springframework.data.annotation.Transient;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

public class NodeDataDto {
    private Long id;
    private double temperature;
    private double humidity;
    private LocalDateTime dateTime;
    private UUID nodeId;
    private String nameNode;

    public NodeDataDto(){
        this.dateTime= LocalDateTime.now(ZoneId.of("GMT+1"));
    }
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

    public UUID getNodeId() {
        return nodeId;
    }

    public void setNodeId(UUID idNode) {
        this.nodeId = idNode;
    }

    public String getNameNode() {
        return nameNode;
    }

    public void setNameNode(String nameNode) {
        this.nameNode = nameNode;
    }
}
