package org.eheio.projet.iot.controller;

import org.eheio.projet.iot.model.User;
import org.eheio.projet.iot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{name}")
    public User profile(@PathVariable String name){
        return userService.getUserByUserName(name);
    }
}
