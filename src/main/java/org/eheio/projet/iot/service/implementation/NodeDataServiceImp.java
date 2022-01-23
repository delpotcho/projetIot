package org.eheio.projet.iot.service.implementation;

import org.eheio.projet.iot.dao.NodeDataRepository;
import org.eheio.projet.iot.model.Node;
import org.eheio.projet.iot.model.NodeData;
import org.eheio.projet.iot.service.NodeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Service
public class NodeDataServiceImp implements NodeDataService {

    @Autowired
    private NodeDataRepository nodeDataRepository;


    @Override
    public List<NodeData> getDataNode(Node node) {
        return node.getData();
    }

    @Override
    public List<NodeData> getAllNodesHourData(LocalDateTime time1) {
        //ex:17h-->18h
        if(time1==null){
            LocalDateTime now=LocalDateTime.now(ZoneId.of("GMT+1")); //Get exact current time (GMT+1)
            LocalDateTime beforeHour=now.minusHours(1);
            System.out.println(now+"-----"+beforeHour);
            return nodeDataRepository.getNodeDataByDateTimeBetween(beforeHour,now);

        }
        return nodeDataRepository.getNodeDataByDateTimeBetween(time1,time1.plusHours(1));
    }

    @Override
    public List<NodeData> getAllNodesDayData(LocalDateTime dateTime1) {
        //ex:00h-->23h

        if(dateTime1==null){
            LocalDateTime now=LocalDateTime.now(ZoneId.of("GMT+1"));
            LocalDateTime beforeDay=now.minusDays(1);
            System.out.println(now+"-----"+beforeDay);
            return nodeDataRepository.getNodeDataByDateTimeBetween(beforeDay,now);

        }
        return nodeDataRepository.getNodeDataByDateTimeBetween(dateTime1,dateTime1.plusDays(1));
    }
    public NodeData getLastDataByNode(Node node){
        return  nodeDataRepository.getTopByNodeIdOrderByDateTimeDesc(node.getId());
    }

    @Override
    public NodeData saveNodeData(NodeData data) throws RuntimeException {
        if(data.getNode()==null){
             throw new RuntimeException("Node Not Found");
        }
       return  nodeDataRepository.save(data);
    }


}
