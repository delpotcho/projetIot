package org.eheio.projet.iot.service;

import org.eheio.projet.iot.dto.request.NodeDto;
import org.eheio.projet.iot.model.Envirenment;
import org.eheio.projet.iot.model.Node;

import java.util.List;
import java.util.UUID;

public interface NodeService {
    public List<Node> getAllNodes();

    public Node getUsNodeById(UUID id);

    public void deleteNode(Node node);

    public void addNode(Node node);

    public Node updateNode(Node node);
}
