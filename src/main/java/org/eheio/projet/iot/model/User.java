package org.eheio.projet.iot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Data @AllArgsConstructor @Builder @NoArgsConstructor
public class User {
    @Id
    private UUID ID;
    private String name;
    private String email;
    @ManyToOne
    @JoinColumn(name="role")
    private Role role;


}
