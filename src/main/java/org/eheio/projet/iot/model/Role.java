package org.eheio.projet.iot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ID ;
    private String name ;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role(String name) {
        this.name=name;
    }

    @Override
    public String getAuthority() {
        return "ROLE_"+name.toUpperCase();
    }
}
