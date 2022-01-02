package org.eheio.projet.iot.service;

import org.eheio.projet.iot.model.Node;
import org.eheio.projet.iot.model.NodeData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NodeDataService  {
    List<NodeData> getDataNode(Node node);
    List<NodeData> getAllNodesHourData(LocalDateTime time1);
    List<NodeData> getAllNodesDayData(LocalDateTime dateTime1);
    NodeData saveNodeData(NodeData data);

}
