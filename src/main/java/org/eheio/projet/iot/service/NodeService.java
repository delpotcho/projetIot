package org.eheio.projet.iot.service;

import org.eheio.projet.iot.model.Node;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public interface NodeService {
     List<Node> getAllNodes();

     Node getUsNodeById(UUID id);

     void deleteNode(Node node);

     Node addNode(Node node);

     Node updateNode(Node node);

}
