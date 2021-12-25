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
    public List<Node> getAllNodes() {
        return nodeRepsitory.findAll();
    }

    @Override
    public Node getUsNodeById(UUID id) {
        return nodeRepsitory.getById(id);
    }

    @Override
    public void deleteNode(Node node) {
        nodeRepsitory.delete(node);

    }

    @Override
    public void addNode(Node node) {
        nodeRepsitory.save(node);


    }

    @Override
    public Node updateNode(Node node) {
       return nodeRepsitory.save(node);

    }
}
