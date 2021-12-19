package org.eheio.projet.iot.controller;

import org.eheio.projet.iot.dto.request.LoginInfoDto;
import org.eheio.projet.iot.dto.request.RegisterInfoDto;
import org.eheio.projet.iot.model.Role;
import org.eheio.projet.iot.model.User;
import org.eheio.projet.iot.security.JWTProvider;
import org.eheio.projet.iot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@RestController
@RequestMapping("/")
public class AuthenticationController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTProvider jwtProvider;
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody  LoginInfoDto infoDto, HttpServletResponse response){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(infoDto.getUsername(),infoDto.getPassword()));

        if(authentication.isAuthenticated()){
            Set<Role> roles = userService.getUserByUserName(infoDto.getUsername()).getRoles();
           String token= this.jwtProvider.generateToken(infoDto.getUsername(),roles);
           Cookie cookie = new Cookie("auth",token);
           cookie.setHttpOnly(true);
           cookie.setMaxAge(5000);
           cookie.setPath("/");
           response.addCookie(cookie);
           return  ResponseEntity.ok().body("user has been authenticated");
        }

        return  ResponseEntity.badRequest().body("user or password incorrect");

    }
    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody RegisterInfoDto infoDto, HttpServletResponse response){
        User user =userService.getUserByUserName(infoDto.getUsername());
        if(user!=null){
            return  ResponseEntity.badRequest().body("user exist");
        }
        user=new User();
        user.setUsername(infoDto.getUsername());
        user.setPassword(infoDto.getPassword());
        userService.addUser(user);
        return  ResponseEntity.ok().body("user created");
    }

}
