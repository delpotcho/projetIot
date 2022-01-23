package org.eheio.projet.iot.controller;
import org.eheio.projet.iot.dto.request.NodeDataDto;
import org.eheio.projet.iot.dto.request.NodeDto;
import org.eheio.projet.iot.dto.response.EnvironmentDto;
import org.eheio.projet.iot.dto.response.ResponseMessage;
import org.eheio.projet.iot.model.Environment;
import org.eheio.projet.iot.model.Node;
import org.eheio.projet.iot.model.NodeData;
import org.eheio.projet.iot.service.EnvironmentService;
import org.eheio.projet.iot.service.NodeDataService;
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
    private NodeDataService nodeDataService;
    @Autowired
    private EnvironmentService environmentService;
    @Autowired
    ModelMapper modelMapper ;

    @PostMapping("/new")
    public ResponseEntity<ResponseMessage> saveNode(@RequestBody NodeDto nodeDto) {
        try{
            if (nodeDto != null) {
                Environment environment = environmentService.getEnvironmentById(nodeDto.getEnvironmentId());

                Node node = modelMapper.map(nodeDto,Node.class);
                node.setEnvironment(environment);
                nodeService.addNode(node);
                return ResponseEntity.ok().body(new ResponseMessage("Node added",HttpStatus.OK));
            }
            return ResponseEntity.badRequest().body(new ResponseMessage("node info is empty",HttpStatus.BAD_REQUEST));
        }catch (RuntimeException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseMessage("Something wrong : "+e.getMessage(),HttpStatus.BAD_REQUEST));
        }

    }

    @GetMapping("/")
    public List<NodeDto> getAllNode() {
         List<Node> nodes = nodeService.getAllNodes();
       List <NodeDto> nodeDto = nodes.stream().map((node)->modelMapper.map(node,NodeDto.class)).collect(Collectors.toList());
         return nodeDto ;
    }

    @GetMapping("/{nodeId}")
    public NodeDto getNodeById(@PathVariable("nodeId") UUID nodeIde) {
       Node node= nodeService.getUsNodeById(nodeIde);
      return   modelMapper.map(node, NodeDto.class);
    }


    @DeleteMapping("/")
    public ResponseEntity<?> deleteNode(@RequestParam("node") NodeDto nodeDto) {
        Node node = modelMapper.map(nodeDto,Node.class);
        nodeService.deleteNode(node);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NodeDto> updateNode(@PathVariable("id") NodeDto nodeDto) {
        Node node = modelMapper.map(nodeDto ,Node.class);
        Node updateNode = nodeService.updateNode(node);
        NodeDto nodeDtoUpdate =modelMapper.map(updateNode,NodeDto.class);
        return ResponseEntity.ok(nodeDtoUpdate);
    }
    @GetMapping("/{id}/last")
    public NodeDataDto getLastData(@PathVariable("id") UUID id){
        Node node = nodeService.getUsNodeById(id);
        if(node != null){
            return modelMapper.map(nodeDataService.getLastDataByNode(node),NodeDataDto.class);
        }
        return  null;
    }
}