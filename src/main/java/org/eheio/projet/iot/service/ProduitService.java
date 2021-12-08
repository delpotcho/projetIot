package org.eheio.projet.iot.service;

import org.eheio.projet.iot.model.Produit;
import org.eheio.projet.iot.model.Produit;

import java.util.List;
import java.util.UUID;

public interface ProduitService {
    public List<Produit> getAllProduits();

    public Produit getProduitById(UUID id);

    public void deleteProduit(Produit produit);

    public void addProduit(Produit produit);

    public void updateProduit(Produit produit);
}
