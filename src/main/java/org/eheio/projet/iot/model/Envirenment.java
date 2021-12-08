package org.eheio.projet.iot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Envirenment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID ID;
    private Float temperatre;
    private Float humidity;
    @ManyToMany
    private List<Category> categories;


}
