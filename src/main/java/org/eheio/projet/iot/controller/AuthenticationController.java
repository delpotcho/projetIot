package org.eheio.projet.iot.controller;

import org.eheio.projet.iot.dto.request.LoginInfoDto;
import org.eheio.projet.iot.dto.request.RegisterInfoDto;
import org.eheio.projet.iot.dto.response.ResponseMessage;
import org.eheio.projet.iot.model.Role;
import org.eheio.projet.iot.model.User;
import org.eheio.projet.iot.security.JWTProvider;
import org.eheio.projet.iot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
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
    public ResponseEntity<ResponseMessage> login(@RequestBody  LoginInfoDto infoDto, HttpServletResponse response){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(infoDto.getUsername(),infoDto.getPassword()));
        ResponseMessage responseMessage;
        if(authentication.isAuthenticated()){
            Set<Role> roles = userService.getUserByUserName(infoDto.getUsername()).getRoles();
           String token= this.jwtProvider.generateToken(infoDto.getUsername(),roles);
           Cookie cookie = new Cookie("auth",token);
           cookie.setHttpOnly(true);
           cookie.setMaxAge(5000);
           cookie.setPath("/");
           response.addCookie(cookie);
            responseMessage = new ResponseMessage("user has been authenticated",HttpStatus.ACCEPTED);
           return  ResponseEntity.ok().body(responseMessage);
        }
        responseMessage = new ResponseMessage("user or password incorrect",HttpStatus.BAD_REQUEST);

        return  ResponseEntity.badRequest().body(responseMessage);

    }
    @PostMapping("register")
    public ResponseEntity<ResponseMessage> register(@RequestBody RegisterInfoDto infoDto, HttpServletResponse response){
        User user =userService.getUserByUserName(infoDto.getUsername());
        ResponseMessage msg;
        if(user!=null){
            msg = new ResponseMessage("user exist", HttpStatus.BAD_REQUEST);
            return  ResponseEntity.badRequest().body(msg);
        }
        user=new User();
        user.setUsername(infoDto.getUsername());
        user.setPassword(infoDto.getPassword());
        userService.addUser(user);
         msg = new ResponseMessage("user added", HttpStatus.ACCEPTED);
        return  ResponseEntity.ok().body(msg);
    }
    @GetMapping("connected")
    public ResponseEntity<ResponseMessage> isLogIn(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        if(!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()){
            return  ResponseEntity.ok().body(new ResponseMessage("connected",HttpStatus.ACCEPTED));
        }
        return  new ResponseEntity<>(new ResponseMessage("not connected",HttpStatus.UNAUTHORIZED),HttpStatus.UNAUTHORIZED);
    }


}
