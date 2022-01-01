package org.eheio.projet.iot.controller;
import org.eheio.projet.iot.dto.request.NodeDto;
import org.eheio.projet.iot.model.Node;
import org.eheio.projet.iot.service.NodeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/node")
public class NodeController {
    @Autowired
    private NodeService nodeService;
    @Autowired
    ModelMapper modelMapper ;
    /************* GET  DATA By [Hour,Day,Weekly,Monthly]**********************/
    /***!!!! change later !!!! **/
    @GetMapping("/hours")
    public List<NodeDto> getNodeHoursData() {
        //ex:18h->19h
        List<Node> nodes= nodeService.getAllNodesHourData(null);

        List<NodeDto> nodesDto=nodes.stream().map(n->modelMapper.map(n,NodeDto.class)).collect(Collectors.toList());
        return nodesDto;
    }
    @GetMapping("/day")
    public List<NodeDto> getNodeDayData() {
        //ex:18h->19h
        List<Node> nodes= nodeService.getAllNodesDayData(null);
        List<NodeDto> nodesDto=nodes.stream().map(n->modelMapper.map(n,NodeDto.class)).collect(Collectors.toList());
        return nodesDto;
    }
    @PostMapping("/new")
    public ResponseEntity<?> saveNode(@RequestParam("node") NodeDto nodeDto) {
        if (nodeDto != null) {

           Node node = modelMapper.map(nodeDto,Node.class);
            nodeService.addNode(node);
            return ResponseEntity.ok().body("add well");
        }
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @GetMapping("/")
    public List<NodeDto> getAllNode() {
         List<Node> nodes = nodeService.getAllNodes();
       List <NodeDto> nodeDto = nodes.stream().map((node)->modelMapper.map(node,NodeDto.class)).collect(Collectors.toList());
         return nodeDto ;
    }

    @GetMapping("node/{nodeId}")
    public NodeDto getNodeById(@PathVariable("nodeId") UUID nodeIde) {
       Node node= nodeService.getUsNodeById(nodeIde);
      return   modelMapper.map(node, NodeDto.class);
    }

    @DeleteMapping("node")
    public ResponseEntity<?> deleteNode(@RequestParam("node") NodeDto nodeDto) {
        Node node = modelMapper.map(nodeDto,Node.class);
        nodeService.deleteNode(node);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("node/{id}")
    public ResponseEntity<NodeDto> updateNode(@PathVariable("id") NodeDto nodeDto) {
        Node node = modelMapper.map(nodeDto ,Node.class);
        Node updateNode = nodeService.updateNode(node);
        NodeDto nodeDtoUpdate =modelMapper.map(updateNode,NodeDto.class);
        return ResponseEntity.ok(nodeDtoUpdate);
    }
}