package org.eheio.projet.iot.service;

import org.eheio.projet.iot.model.Node;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public interface NodeService {
    public List<Node> getAllNodes();
    public List<Node> getAllNodesHourData(LocalDateTime time1);
    public List<Node> getAllNodesDayData(LocalDateTime dateTime1);
    public Node getUsNodeById(UUID id);

    public void deleteNode(Node node);

    public void addNode(Node node);

    public Node updateNode(Node node);
}
