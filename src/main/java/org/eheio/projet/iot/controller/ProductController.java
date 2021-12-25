package org.eheio.projet.iot.controller;

import org.eheio.projet.iot.dto.request.NodeDto;
import org.eheio.projet.iot.dto.response.ProduitDto;
import org.eheio.projet.iot.model.Node;
import org.eheio.projet.iot.model.Produit;
import org.eheio.projet.iot.service.ProduitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class ProductController {
<<<<<<< HEAD
    @Autowired
    private ProduitService produitService;
    ModelMapper modelMapper;

    @PostMapping("product")
    public ResponseEntity<?> addProduct(@PathVariable("product") ProduitDto produitDto) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("product")
    public ResponseEntity<?> saveNode(@RequestParam("product") ProduitDto productDto) {

        if (productDto != null) {

            Produit produit = modelMapper.map(productDto, Produit.class);
            produitService.addProduit(produit);
           return ResponseEntity.ok().body("add well");
        } else {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @GetMapping("produit")
    public List<ProduitDto> getAllProduit() {
        List<Produit> produits = produitService.getAllProduits();
        List<ProduitDto> produitDtos= produits.stream().map((p) -> modelMapper.map(p, ProduitDto.class)).collect(Collectors.toList());
        return produitDtos;
    }

    @GetMapping("produit/{produitId}")
    public ProduitDto getProduitById(@PathVariable("produitId") UUID nodeIde) {
        Produit produit = produitService.getProduitById(nodeIde);
        return modelMapper.map(produit, ProduitDto.class);
    }

    @DeleteMapping("produit")
    public ResponseEntity<?> deletePrudact(@RequestParam("node") ProduitDto produitDto) {
        Produit produit = modelMapper.map(produitDto, Produit.class);
        produitService.deleteProduit(produit);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("produit/{id}")
    public ResponseEntity<?> updateNode(@PathVariable("id") UUID produitId) {

        return ResponseEntity.ok(HttpStatus.OK);
=======
    @RequestMapping("product")
    public String home(){
        return  "hello product";
>>>>>>> f53787e89dee26ff9a1bfee98176a0355e32f086
    }
}
