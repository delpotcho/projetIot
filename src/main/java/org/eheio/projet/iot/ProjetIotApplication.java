package org.eheio.projet.iot;

import org.eheio.projet.iot.model.Role;
import org.eheio.projet.iot.security.JWTProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ProjetIotApplication {

    public static void main(String[] args) {

        JWTProvider jwtProvider = new JWTProvider();
        Set<Role> roles=new HashSet<>();
        roles.add(new Role("Admin"));
        jwtProvider.generateToken("zaki",roles);

    }
}
