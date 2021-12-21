package org.eheio.projet.iot.controller;

import org.eheio.projet.iot.dto.request.LoginInfoDto;
import org.eheio.projet.iot.dto.request.NodeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class NodeController {

    public ResponseEntity<?> getNode(@RequestBody NodeDto nodeDto) {

        return  ResponseEntity.ok().body("add well");
    }
}