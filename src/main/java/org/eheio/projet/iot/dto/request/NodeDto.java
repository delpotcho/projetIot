package org.eheio.projet.iot.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eheio.projet.iot.model.Environment;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class NodeDto {
    private UUID id;
    private String name ;
    private UUID environmentId;

    private  List<NodeDataDto>  data;

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

    public UUID getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(UUID environmentId) {
        this.environmentId = environmentId;
    }

    public List<NodeDataDto> getData() {
        return data;
    }

    public void setData(List<NodeDataDto> data) {
        this.data = data;
    }
}
