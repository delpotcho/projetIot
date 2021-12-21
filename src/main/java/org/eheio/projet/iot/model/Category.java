package org.eheio.projet.iot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ID ;
    private String type ;
    @ManyToMany(mappedBy = "categories")
    private List<Produit> produits;
    @ManyToMany(mappedBy = "categories")
    private List<Envirenment>envirenments;




}
