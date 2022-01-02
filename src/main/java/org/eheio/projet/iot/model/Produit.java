package org.eheio.projet.iot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Produit {@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
    private UUID ID ;
    private String name ;
    private Float tempMax;
    private Float tempMin;
    @ManyToMany
    private List<Category> categories;

}
