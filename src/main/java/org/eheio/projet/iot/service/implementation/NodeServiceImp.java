package org.eheio.projet.iot.service.implementation;

import org.eheio.projet.iot.dao.NodeRepsitory;
import org.eheio.projet.iot.dto.request.NodeDto;
import org.eheio.projet.iot.model.Node;
import org.eheio.projet.iot.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class NodeServiceImp implements NodeService {
    @Autowired
   private  NodeRepsitory nodeRepsitory;
    @Override
    public List<NodeDto> getAllNodes() {
        return nodeRepsitory.findAll();
    }

    @Override
    public NodeDto getUsNodeById(UUID id) {
        return nodeRepsitory.getById(id);
    }

    @Override
    public void deleteNode(NodeDto node) {
        nodeRepsitory.delete(node);

    }

    @Override
    public void addNode(NodeDto node) {
        nodeRepsitory.save(node);


    }

    @Override
    public void updateNode(NodeDto node) {
        nodeRepsitory.save(node);

    }
}
