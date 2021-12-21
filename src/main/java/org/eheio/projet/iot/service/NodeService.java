package org.eheio.projet.iot.service;

import org.eheio.projet.iot.dto.request.NodeDto;
import org.eheio.projet.iot.model.Envirenment;
import org.eheio.projet.iot.model.Node;

import java.util.List;
import java.util.UUID;

public interface NodeService {
    public List<NodeDto> getAllNodes();

    public NodeDto getUsNodeById(UUID id);

    public void deleteNode(NodeDto node);

    public void addNode(NodeDto node);

    public void updateNode(NodeDto node);
}
