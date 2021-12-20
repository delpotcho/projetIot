package org.eheio.projet.iot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProductController {

    @RequestMapping("product")
    public String home(){
        return  "hello product";
    }
}
