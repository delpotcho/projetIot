package org.eheio.projet.iot.controller;

import org.eheio.projet.iot.dto.response.EnvironmentDto;
import org.eheio.projet.iot.dto.response.ProductDto;
import org.eheio.projet.iot.dto.response.ResponseMessage;
import org.eheio.projet.iot.model.Environment;
import org.eheio.projet.iot.service.EnvironmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/environment")
public class EnvironmentController {

    @Autowired
    private EnvironmentService environmentService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    public List<EnvironmentDto> getEnvironments(){
        List<Environment> environments= environmentService.getAllEnvironments();

        List<EnvironmentDto> environmentsDto=environments.stream().map((e) -> modelMapper.map(e, EnvironmentDto.class)).collect(Collectors.toList());
        return environmentsDto;
    }
    @GetMapping("/{id}")
    public EnvironmentDto getEnvironment(@PathVariable("id") UUID id){
        Environment environment= environmentService.getEnvironmentById(id);

        EnvironmentDto environmentDto=modelMapper.map(environment, EnvironmentDto.class);
        return environmentDto;
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseMessage> newEnvironment(@RequestBody EnvironmentDto environmentDto){
        Environment environment=modelMapper.map(environmentDto,Environment.class);
        environmentService.addEnvironment(environment);
        ResponseMessage response = new ResponseMessage("Environment Bien Ajouter", HttpStatus.OK);
        return ResponseEntity.ok(response);
    }
}
