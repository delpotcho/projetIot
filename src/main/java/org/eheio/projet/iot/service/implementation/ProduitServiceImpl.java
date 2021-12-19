package org.eheio.projet.iot.service.implementation;

import org.eheio.projet.iot.dao.ProduitRepository;
import org.eheio.projet.iot.model.Produit;
import org.eheio.projet.iot.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class ProduitServiceImpl implements ProduitService {
    @Autowired
    private ProduitRepository produitRepository;
    
    @Override
    public List<Produit> getAllProduits() {
        return null;
    }

    @Override
    public Produit getProduitById(UUID id) {
        return null;
    }

    @Override
    public void deleteProduit(Produit produit) {

    }

    @Override
    public void addProduit(Produit produit) {

    }

    @Override
    public void updateProduit(Produit produit) {

    }
}
