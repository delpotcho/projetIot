package org.eheio.projet.iot.security;

import io.jsonwebtoken.*;
import org.eheio.projet.iot.model.Role;
<<<<<<< HEAD

=======
import org.eheio.projet.iot.service.implementation.UserServiceImp;
import org.eheio.projet.iot.service.implimentation.MyUserDetailsService;
>>>>>>> 37843754ee18ea4c1bae3ad68934a4b81e20f637
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.Set;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
<<<<<<< HEAD
=======

>>>>>>> 37843754ee18ea4c1bae3ad68934a4b81e20f637
public class JWTProvider {


    @Autowired
<<<<<<< HEAD
    private org.eheio.projet.iot.service.implimentation.MyUserDetailsService userService;
    private static final long DURATION = Duration.ofMinutes(5).toMillis(); //minute
=======
    private MyUserDetailsService userService;
    private static final long DURATION = Duration.ofMinutes(1).toMillis(); //minute
>>>>>>> 37843754ee18ea4c1bae3ad68934a4b81e20f637

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
        try{
            Claims claims=Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            return claims;
        }catch (JwtException e){
            return  null;
        }



    }
    public Authentication getAuthentication(String username){
        UserDetails user=userService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),user.getAuthorities());
    }

}
