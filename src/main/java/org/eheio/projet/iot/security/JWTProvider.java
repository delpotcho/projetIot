package org.eheio.projet.iot.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.eheio.projet.iot.model.Role;
<<<<<<< HEAD
import org.eheio.projet.iot.service.implementation.UserServiceImp;
=======
import org.eheio.projet.iot.service.implimentation.MyUserDetailsService;
import org.eheio.projet.iot.service.implimentation.UserServiceImp;
>>>>>>> 8d89653d32e24cf2b4b3dae150f0a0637c6c07f5
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.Set;

import  io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

<<<<<<< HEAD
=======
import javax.annotation.PostConstruct;

@Component
>>>>>>> 8d89653d32e24cf2b4b3dae150f0a0637c6c07f5
public class JWTProvider {


    @Autowired
    private MyUserDetailsService userService;
    private static final long DURATION = Duration.ofMinutes(5).toMillis(); //minute

    private static final   String SECRET_KEY=Base64.getEncoder().encodeToString("IOTAPP2022".getBytes());



    public String generateToken(String username, Set<Role> roles){
        Claims claims= Jwts.claims().setSubject(username);
        claims.put("role",roles);
        Date dateNow= new Date();
        Date dateExp=new Date(dateNow.getTime()+DURATION);
        return Jwts.builder().setClaims(claims).setIssuedAt(dateNow).setExpiration(dateExp).signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }

    //get information from  token
    public Claims getClaimsFromToken(String token){
        Claims claims=Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims;
    }
    public Authentication getAuthentication(String username){
        UserDetails user=userService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),user.getAuthorities());
    }

}
