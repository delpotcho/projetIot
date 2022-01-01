package org.eheio.projet.iot.service.implementation;

import org.eheio.projet.iot.dao.NodeRepsitory;
import org.eheio.projet.iot.dto.request.NodeDto;
import org.eheio.projet.iot.model.Node;
import org.eheio.projet.iot.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
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
    public List<Node> getAllNodesHourData(LocalDateTime time1){
        //ex:17h-->18h
        if(time1==null){
            LocalDateTime now=LocalDateTime.now(ZoneId.of("GMT+1")); //Get exact current time (GMT+1)
            LocalDateTime beforeHour=now.minusHours(1);
            System.out.println(now+"-----"+beforeHour);
           return nodeRepsitory.getNodesByDateTimeBetween(beforeHour,now);

        }
        return nodeRepsitory.getNodesByDateTimeBetween(time1,time1.plusHours(1));
    }

    @Override
    public List<Node> getAllNodesDayData(LocalDateTime dateTime1) {
        //ex:00h-->23h

        if(dateTime1==null){
            LocalDateTime now=LocalDateTime.now(ZoneId.of("GMT+1"));
            LocalDateTime beforeDay=now.minusDays(1);
            System.out.println(now+"-----"+beforeDay);
            return nodeRepsitory.getNodesByDateTimeBetween(beforeDay,now);

        }
        return nodeRepsitory.getNodesByDateTimeBetween(dateTime1,dateTime1.plusDays(1));
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
