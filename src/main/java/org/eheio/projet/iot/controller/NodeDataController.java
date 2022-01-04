package org.eheio.projet.iot.controller;

import org.eheio.projet.iot.dto.request.NodeDataDto;
import org.eheio.projet.iot.dto.request.NodeDto;
import org.eheio.projet.iot.dto.response.ResponseMessage;
import org.eheio.projet.iot.model.Node;
import org.eheio.projet.iot.model.NodeData;
import org.eheio.projet.iot.service.NodeDataService;
import org.eheio.projet.iot.service.NodeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/node/data")
public class NodeDataController {
    @Autowired
    private NodeService nodeService;
    @Autowired
    private NodeDataService nodeDataService;
    @Autowired
    ModelMapper modelMapper ;
    //***Get Last Data

    @GetMapping("/now/{nodeId}")
    public List<NodeDataDto> getNodeNowData(@PathVariable("nodeId")UUID nodeId) {
        //ex:18h->19h
        List<NodeData> nodesData= nodeDataService.getLastNodeData(nodeId);
        List<NodeDataDto> nodesDto=nodesData.stream().map(n->modelMapper.map(n,NodeDataDto.class)).collect(Collectors.toList());
        return nodesDto;
    }
    /************* GET  DATA By [Hour,Day,Weekly,Monthly]**********************/
    /***!!!! change later !!!! **/
    @GetMapping("/hours")
    public List<NodeDataDto> getNodeHoursData() {
        //ex:18h->19h
        List<NodeData> nodes= nodeDataService.getAllNodesHourData(null);

        List<NodeDataDto> nodesDto=nodes.stream().map(n->modelMapper.map(n,NodeDataDto.class)).collect(Collectors.toList());
        return nodesDto;
    }
    @GetMapping("/day")
    public List<NodeDataDto> getNodeDayData() {
        //ex:18h->19h
        List<NodeData> dataNode= nodeDataService.getAllNodesHourData(null);
        List<NodeDataDto> nodesDto=dataNode.stream().map(n->modelMapper.map(n,NodeDataDto.class)).collect(Collectors.toList());
        return nodesDto;
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseMessage> newNodeData(@RequestBody NodeDataDto data){
        try{
            //Get Node
            Node node =nodeService.getUsNodeById(data.getNodeId());
            NodeData nodeData = modelMapper.map(data,NodeData.class);
           nodeData.setNode(node);
            nodeDataService.saveNodeData(nodeData);
            return ResponseEntity.ok(new ResponseMessage("data inserted", HttpStatus.OK));
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseMessage("something wrong :"+e.getMessage(), HttpStatus.BAD_REQUEST));
        }




    }
}
